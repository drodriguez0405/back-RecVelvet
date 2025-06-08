package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.dtos.SalaDTO;
import com.example.Backend_RecVelvet.modelos.Sala;
import com.example.Backend_RecVelvet.repositorios.ISalaRepositorio;
import com.example.Backend_RecVelvet.servicios.SalaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sala")
@CrossOrigin(origins = "*")
public class ControladorSala {
    @Autowired
    private SalaServicio servicio;

    @Autowired
    private ISalaRepositorio salaRepositorio;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrarSala(@Valid @RequestBody SalaDTO datosSala) {
        try {
            Sala nuevaSala = new Sala();
            nuevaSala.setId(datosSala.getId());
            nuevaSala.setNombre(datosSala.getNombre());
            nuevaSala.setCapacidad(datosSala.getCapacidad());
            nuevaSala.setDescripcion(datosSala.getDescripcion());

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(servicio.guardarSala(nuevaSala));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarTodasSalas() {
        try {
            return ResponseEntity.ok(servicio.buscarTodasSalas());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarSalaPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(servicio.buscarSalaPorId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modificarSala(@PathVariable Integer id,
                                           @Valid @RequestBody SalaDTO datosSala) {
        try {
            // Convertir DTO a Entidad
            Sala salaActualizada = new Sala();
            salaActualizada.setId(id);
            salaActualizada.setNombre(datosSala.getNombre());
            salaActualizada.setCapacidad(datosSala.getCapacidad());
            salaActualizada.setDescripcion(datosSala.getDescripcion());

            return ResponseEntity.ok(servicio.modificarSala(id, salaActualizada));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarSala(@PathVariable Integer id) {
        try {
            servicio.eliminarSala(id);
            return ResponseEntity.ok("Sala eliminada correctamente");
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
