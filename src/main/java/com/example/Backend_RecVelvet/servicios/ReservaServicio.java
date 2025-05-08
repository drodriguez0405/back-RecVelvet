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

    // Guardar reserva
    public Reserva guardarReserva(Reserva datosReserva) throws Exception {
        try {
            return this.repositorio.save(datosReserva);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas las reservas
    public List<Reserva> buscarTodasReservas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar reserva por ID
    public Reserva buscarReservaPorId(Integer idReserva) throws Exception {
        try {
            Optional<Reserva> reservaBuscada = this.repositorio.findById(idReserva);
            if (reservaBuscada.isPresent()) {
                return reservaBuscada.get();
            } else {
                throw new Exception("Reserva no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar reserva (actualiza todos los campos)
    public Reserva modificarReserva(Integer id, Reserva datosReserva) throws Exception {
        try {
            Optional<Reserva> reservaBuscada = this.repositorio.findById(id);
            if (reservaBuscada.isPresent()) {
                Reserva reservaActualizar = reservaBuscada.get();
                reservaActualizar.setFechaReserva(datosReserva.getFechaReserva());
                reservaActualizar.setCodigoReserva(datosReserva.getCodigoReserva());
                reservaActualizar.setTotalPagado(datosReserva.getTotalPagado());
                reservaActualizar.setEstadoPago(datosReserva.getEstadoPago());
                reservaActualizar.setMetodoPago(datosReserva.getMetodoPago());
                reservaActualizar.setTransaccionId(datosReserva.getTransaccionId());
                return this.repositorio.save(reservaActualizar);
            } else {
                throw new Exception("Reserva no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar reserva
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
