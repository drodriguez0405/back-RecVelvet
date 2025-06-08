package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.dtos.PeliculaDTO;
import com.example.Backend_RecVelvet.modelos.Pelicula;
import com.example.Backend_RecVelvet.servicios.PeliculaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pelicula")
@CrossOrigin(origins = "*")
public class ControladorPelicula {

    @Autowired
    private PeliculaServicio peliculaServicio;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrarPelicula(@Valid @RequestBody PeliculaDTO datosPelicula) {
        try {
            Pelicula nuevaPelicula = new Pelicula();
            nuevaPelicula.setTitulo(datosPelicula.getTitulo());
            nuevaPelicula.setSinopsis(datosPelicula.getSinopsis());
            nuevaPelicula.setDuracionMinutos(datosPelicula.getDuracionMinutos());
            nuevaPelicula.setGenero(datosPelicula.getGenero());
            nuevaPelicula.setClasificacion(datosPelicula.getClasificacion());
            nuevaPelicula.setDirector(datosPelicula.getDirector());
            nuevaPelicula.setActores(datosPelicula.getActores());
            nuevaPelicula.setUrlPortada(datosPelicula.getUrlPortada());
            nuevaPelicula.setUrlTrailer(datosPelicula.getUrlTrailer());
            nuevaPelicula.setFechaLanzamiento(datosPelicula.getFechaLanzamiento());
            nuevaPelicula.setEstadoPelicula(datosPelicula.getEstadoPelicula());

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(peliculaServicio.guardarPelicula(nuevaPelicula));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarTodasPeliculas() {
        try {
            return ResponseEntity.ok(peliculaServicio.buscarTodasPeliculas());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarPeliculaPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(peliculaServicio.buscarPeliculaPorId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modificarPelicula(@PathVariable Integer id,
                                               @Valid @RequestBody PeliculaDTO datosPelicula) {
        try {
            Pelicula peliculaActualizada = new Pelicula();
            peliculaActualizada.setTitulo(datosPelicula.getTitulo());
            // ... (setear todos los campos como en el POST)

            return ResponseEntity.ok(peliculaServicio.modificarPelicula(id, peliculaActualizada));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarPelicula(@PathVariable Integer id) {
        try {
            peliculaServicio.eliminarPelicula(id);
            return ResponseEntity.ok("Película eliminada correctamente");
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
