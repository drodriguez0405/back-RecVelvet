package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.dtos.ReservaDTO;
import com.example.Backend_RecVelvet.modelos.Reserva;
import com.example.Backend_RecVelvet.servicios.ReservaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins = "*")
public class ControladorReserva {
    @Autowired
    ReservaServicio reservaServicio;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrarReserva(@Valid @RequestBody ReservaDTO datosReserva) {
        try {
            Reserva nuevaReserva = new Reserva();
            nuevaReserva.setCodigoReserva(datosReserva.getCodigoReserva());
            nuevaReserva.setTotalPagado(datosReserva.getTotalPagado());
            nuevaReserva.setEstadoPago(datosReserva.getEstadoPago());
            nuevaReserva.setMetodoPago(datosReserva.getMetodoPago());
            nuevaReserva.setTransaccionId(datosReserva.getTransaccionId());
            // Las relaciones se manejarían en el servicio

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(reservaServicio.guardarReservaConRelaciones(
                            nuevaReserva,
                            datosReserva.getUsuarioId(),
                            datosReserva.getHorarioId()));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarTodasReservas() {
        try {
            return ResponseEntity.ok(reservaServicio.buscarTodasReservas());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarReservaPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(reservaServicio.buscarReservaPorId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modificarReserva(@PathVariable Integer id,
                                              @Valid @RequestBody ReservaDTO datosReserva) {
        try {
            return ResponseEntity.ok(reservaServicio.actualizarReservaDesdeDTO(id, datosReserva));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarReserva(@PathVariable Integer id) {
        try {
            reservaServicio.eliminarReserva(id);
            return ResponseEntity.ok("Reserva eliminada correctamente");
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
