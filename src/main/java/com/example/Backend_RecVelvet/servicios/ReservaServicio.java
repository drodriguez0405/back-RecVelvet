package com.example.Backend_RecVelvet.servicios;

import com.example.Backend_RecVelvet.dtos.ReservaDTO;
import com.example.Backend_RecVelvet.modelos.Horario;
import com.example.Backend_RecVelvet.modelos.Reserva;
import com.example.Backend_RecVelvet.modelos.Usuario;
import com.example.Backend_RecVelvet.repositorios.IHorarioRepositorio;
import com.example.Backend_RecVelvet.repositorios.IReservaRepositorio;
import com.example.Backend_RecVelvet.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServicio {

    @Autowired
    private IReservaRepositorio reservaRepositorio;

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    @Autowired
    private IHorarioRepositorio horarioRepositorio;

    //guardar
    public Reserva guardarReserva(Reserva datosReserva) throws Exception {
        try {
            //validar los datos de entrada
            return this.reservaRepositorio.save(datosReserva);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos los registros
    public List<Reserva> buscarTodasReservas() throws Exception {
        try {
            return this.reservaRepositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar por id
    public Reserva buscarReservaPorId(Integer idReserva) throws Exception {
        try {
            Optional<Reserva> reservaBuscada = this.reservaRepositorio.findById(idReserva);
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
            Optional<Reserva> reservaBuscada = this.reservaRepositorio.findById(id);
            if (reservaBuscada.isPresent()) {
                reservaBuscada.get().setFechaReserva(datosReserva.getFechaReserva());
                reservaBuscada.get().setCodigoReserva(datosReserva.getCodigoReserva());
                reservaBuscada.get().setTotalPagado(datosReserva.getTotalPagado());
                reservaBuscada.get().setEstadoPago(datosReserva.getEstadoPago());
                reservaBuscada.get().setMetodoPago(datosReserva.getMetodoPago());
                reservaBuscada.get().setTransaccionId(datosReserva.getTransaccionId());
                return this.reservaRepositorio.save(reservaBuscada.get());
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
            Optional<Reserva> reservaBuscada = this.reservaRepositorio.findById(id);
            if (reservaBuscada.isPresent()) {
                this.reservaRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Reserva no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    public Reserva guardarReservaConRelaciones(Reserva reserva, Integer usuarioId, Integer horarioId) throws Exception {
        try {
            Usuario usuario = usuarioRepositorio.findById(usuarioId)
                    .orElseThrow(() -> new Exception("Usuario no encontrado con ID: " + usuarioId));

            Horario horario = horarioRepositorio.findById(horarioId)
                    .orElseThrow(() -> new Exception("Horario no encontrado con ID: " + horarioId));

            reserva.setUsuario(usuario);
            reserva.setHorario(horario);

            return reservaRepositorio.save(reserva);
        } catch (Exception error) {
            throw new Exception("Error al guardar reserva con relaciones: " + error.getMessage());
        }
    }

    public Reserva actualizarReservaDesdeDTO(Integer id, ReservaDTO datos) throws Exception {
        Reserva reserva = buscarReservaPorId(id);
        reserva.setEstadoPago(datos.getEstadoPago());
        reserva.setMetodoPago(datos.getMetodoPago());
        // ... otros campos
        return reservaRepositorio.save(reserva);
    }
}
