package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.modelos.ButacaReserva;
import com.example.Backend_RecVelvet.servicios.ButacaReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/butaca-reserva")
public class ControladorButacaReserva {

    @Autowired
    ButacaReservaServicio butacaReservaServicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody ButacaReserva datosPeticion) {
        try {
            return new ResponseEntity<>(this.butacaReservaServicio.guardarButacaReserva(datosPeticion), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return new ResponseEntity<>(this.butacaReservaServicio.buscarTodasButacasReservadas(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.butacaReservaServicio.buscarButacaReservaPorId(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody ButacaReserva datos) {
        try {
            return new ResponseEntity<>(this.butacaReservaServicio.modificarButacaReserva(id, datos), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.butacaReservaServicio.eliminarButacaReserva(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
