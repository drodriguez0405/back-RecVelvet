package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.dtos.ButacaReservaDTO;
import com.example.Backend_RecVelvet.modelos.ButacaReserva;
import com.example.Backend_RecVelvet.servicios.ButacaReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/butaca-reserva")
@CrossOrigin(origins = "*")
public class ControladorButacaReserva {

    @Autowired
    private ButacaReservaServicio butacaReservaServicio;

    @PostMapping
    public ResponseEntity<?> guardarButacaReserva(@RequestBody ButacaReservaDTO datosButaca) {
        try {
            return new ResponseEntity<>(butacaReservaServicio.guardarButacaReserva(datosButaca), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasButacasReservadas() {
        try {
            return new ResponseEntity<>(butacaReservaServicio.buscarTodasButacasReservadas(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarButacaReservaPorId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(butacaReservaServicio.buscarButacaReservaPorId(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarButacaReserva(@PathVariable Integer id, @RequestBody ButacaReservaDTO datosButaca) {
        try {
            return new ResponseEntity<>(butacaReservaServicio.modificarButacaReserva(id, datosButaca), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarButacaReserva(@PathVariable Integer id) {
        try {
            butacaReservaServicio.eliminarButacaReserva(id);
            return new ResponseEntity<>("Butaca-Reserva eliminada correctamente", HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
