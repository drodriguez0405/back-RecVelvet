package com.example.Backend_RecVelvet.servicios;

import com.example.Backend_RecVelvet.dtos.ButacaReservaDTO;
import com.example.Backend_RecVelvet.modelos.ButacaReserva;
import com.example.Backend_RecVelvet.modelos.Reserva;
import com.example.Backend_RecVelvet.modelos.Sala;
import com.example.Backend_RecVelvet.repositorios.IButacaReservaRepositorio;
import com.example.Backend_RecVelvet.repositorios.IReservaRepositorio;
import com.example.Backend_RecVelvet.repositorios.ISalaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ButacaReservaServicio {
    @Autowired
    private IButacaReservaRepositorio repositorio;

    @Autowired
    private IReservaRepositorio reservaRepositorio;

    @Autowired
    private ISalaRepositorio salaRepositorio;

    // Guardar desde DTO
    public ButacaReserva guardarButacaReserva(ButacaReservaDTO datosButaca) throws Exception {
        try {
            ButacaReserva nuevaButaca = new ButacaReserva();
            nuevaButaca.setNumeroFila(datosButaca.getNumeroFila());
            nuevaButaca.setNumeroAsiento(datosButaca.getNumeroAsiento());

            if (datosButaca.getReservaId() != null) {
                Reserva reserva = reservaRepositorio.findById(datosButaca.getReservaId())
                        .orElseThrow(() -> new Exception("Reserva no encontrada"));
                nuevaButaca.setReserva(reserva);
            }

            if (datosButaca.getSalaId() != null) {
                Sala sala = salaRepositorio.findById(datosButaca.getSalaId())
                        .orElseThrow(() -> new Exception("Sala no encontrada"));
                nuevaButaca.setSala(sala);
            }

            return repositorio.save(nuevaButaca);
        } catch (Exception error) {
            throw new Exception("Error al guardar butaca-reserva: " + error.getMessage());
        }
    }

    // Buscar todas
    public List<ButacaReserva> buscarTodasButacasReservadas() throws Exception {
        try {
            return repositorio.findAll();
        } catch (Exception error) {
            throw new Exception("Error al buscar butacas-reservas: " + error.getMessage());
        }
    }

    // Buscar por ID
    public ButacaReserva buscarButacaReservaPorId(Integer id) throws Exception {
        try {
            Optional<ButacaReserva> butaca = repositorio.findById(id);
            return butaca.orElseThrow(() -> new Exception("Butaca-Reserva no encontrada"));
        } catch (Exception error) {
            throw new Exception("Error al buscar butaca-reserva: " + error.getMessage());
        }
    }

    // Modificar desde DTO
    public ButacaReserva modificarButacaReserva(Integer id, ButacaReservaDTO datosButaca) throws Exception {
        try {
            ButacaReserva butacaExistente = repositorio.findById(id)
                    .orElseThrow(() -> new Exception("Butaca-Reserva no encontrada"));

            if (datosButaca.getNumeroFila() != null) {
                butacaExistente.setNumeroFila(datosButaca.getNumeroFila());
            }
            if (datosButaca.getNumeroAsiento() != null) {
                butacaExistente.setNumeroAsiento(datosButaca.getNumeroAsiento());
            }
            if (datosButaca.getReservaId() != null) {
                Reserva reserva = reservaRepositorio.findById(datosButaca.getReservaId())
                        .orElseThrow(() -> new Exception("Reserva no encontrada"));
                butacaExistente.setReserva(reserva);
            }
            if (datosButaca.getSalaId() != null) {
                Sala sala = salaRepositorio.findById(datosButaca.getSalaId())
                        .orElseThrow(() -> new Exception("Sala no encontrada"));
                butacaExistente.setSala(sala);
            }

            return repositorio.save(butacaExistente);
        } catch (Exception error) {
            throw new Exception("Error al modificar butaca-reserva: " + error.getMessage());
        }
    }

    // Eliminar
    public void eliminarButacaReserva(Integer id) throws Exception {
        try {
            if (!repositorio.existsById(id)) {
                throw new Exception("Butaca-Reserva no encontrada");
            }
            repositorio.deleteById(id);
        } catch (Exception error) {
            throw new Exception("Error al eliminar butaca-reserva: " + error.getMessage());
        }
    }
}
