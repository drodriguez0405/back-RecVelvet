package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.modelos.Horario;
import com.example.Backend_RecVelvet.servicios.HorarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horario")
public class ControladorHorario {
    @Autowired
    HorarioServicio horarioServicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Horario datosPeticion) {
        try {
            return new ResponseEntity<>(this.horarioServicio.guardarHorario(datosPeticion), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return new ResponseEntity<>(this.horarioServicio.buscarTodosHorarios(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.horarioServicio.buscarHorarioPorId(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Horario datos) {
        try {
            return new ResponseEntity<>(this.horarioServicio.modificarHorario(id, datos), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.horarioServicio.eliminarHorario(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
