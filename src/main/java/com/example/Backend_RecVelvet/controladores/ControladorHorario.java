package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.dtos.HorarioDTO;
import com.example.Backend_RecVelvet.modelos.Horario;
import com.example.Backend_RecVelvet.servicios.HorarioServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horario")
@CrossOrigin(origins = "*")
public class ControladorHorario {
    @Autowired
    private HorarioServicio horarioServicio;

    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody HorarioDTO datosHorario) {
        try {
            System.out.println("Datos recibidos: " + datosHorario.toString());
            return new ResponseEntity<>(horarioServicio.guardarHorario(datosHorario), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // GET - Buscar todos
    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return new ResponseEntity<>(horarioServicio.buscarTodosHorarios(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(horarioServicio.buscarHorarioPorId(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // PUT - Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @Valid @RequestBody HorarioDTO datosHorario) {
        try {
            return new ResponseEntity<>(horarioServicio.modificarHorario(id, datosHorario), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            horarioServicio.eliminarHorario(id);
            return new ResponseEntity<>("Horario eliminado correctamente", HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
