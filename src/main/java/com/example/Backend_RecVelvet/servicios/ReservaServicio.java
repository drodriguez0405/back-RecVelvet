package com.example.Backend_RecVelvet.servicios;

import com.example.Backend_RecVelvet.modelos.Reserva;
import com.example.Backend_RecVelvet.repositorios.IReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServicio {
    @Autowired
    IReservaRepositorio repositorio;

    //guardar
    public Reserva guardarReserva(Reserva datosReserva) throws Exception {
        try {
            //validar los datos de entrada
            return this.repositorio.save(datosReserva);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos los registros
    public List<Reserva> buscarTodasReservas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar por id
    public Reserva buscarReservaPorId(Integer idReserva) throws Exception {
        try {
            Optional<Reserva> reservaBuscada = this.repositorio.findById(idReserva);
            if (reservaBuscada.isPresent()) {
                return reservaBuscada.get();
            } else {
                throw new Exception("La reserva consultada no está en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //modificar por id
    public Reserva modificarReserva(Integer id, Reserva datosReserva) throws Exception {
        try {
            Optional<Reserva> reservaBuscada = this.repositorio.findById(id);
            if (reservaBuscada.isPresent()) {
                reservaBuscada.get().setFechaReserva(datosReserva.getFechaReserva());
                reservaBuscada.get().setCodigoReserva(datosReserva.getCodigoReserva());
                reservaBuscada.get().setTotalPagado(datosReserva.getTotalPagado());
                reservaBuscada.get().setEstadoPago(datosReserva.getEstadoPago());
                reservaBuscada.get().setMetodoPago(datosReserva.getMetodoPago());
                reservaBuscada.get().setTransaccionId(datosReserva.getTransaccionId());
                return this.repositorio.save(reservaBuscada.get());
            } else {
                throw new Exception("Reserva no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //eliminar por id
    public boolean eliminarReserva(Integer id) throws Exception {
        try {
            Optional<Reserva> reservaBuscada = this.repositorio.findById(id);
            if (reservaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Reserva no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
