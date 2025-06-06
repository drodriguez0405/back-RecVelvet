package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.modelos.Sala;
import com.example.Backend_RecVelvet.servicios.SalaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sala")
public class ControladorSala {
    @Autowired
    SalaServicio servicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Sala datosPeticion) {
        try {
            return new ResponseEntity<>(this.servicio.guardarSala(datosPeticion), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return new ResponseEntity<>(this.servicio.buscarTodasSalas(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.servicio.buscarSalaPorId(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Sala datos) {
        try {
            return new ResponseEntity<>(this.servicio.modificarSala(id, datos), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.servicio.eliminarSala(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
