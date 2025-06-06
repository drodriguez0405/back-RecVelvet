package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.modelos.Pelicula;
import com.example.Backend_RecVelvet.servicios.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pelicula")
public class ControladorPelicula {

    @Autowired
    PeliculaServicio peliculaServicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Pelicula datosPeticion) {
        try {
            return new ResponseEntity<>(this.peliculaServicio.guardarPelicula(datosPeticion), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return new ResponseEntity<>(this.peliculaServicio.buscarTodasPeliculas(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.peliculaServicio.buscarPeliculaPorId(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Pelicula datos) {
        try {
            return new ResponseEntity<>(this.peliculaServicio.modificarPelicula(id, datos), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.peliculaServicio.eliminarPelicula(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
