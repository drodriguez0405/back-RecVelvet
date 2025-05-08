package com.example.Backend_RecVelvet.servicios;

import com.example.Backend_RecVelvet.ayudas.enums.EstadoPeliculaEnum;
import com.example.Backend_RecVelvet.modelos.Pelicula;
import com.example.Backend_RecVelvet.repositorios.IPeliculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServicio {

    @Autowired
    IPeliculaRepositorio repositorio;


    // Guardar película (sin validaciones adicionales)
    public Pelicula guardarPelicula(Pelicula datosPelicula) throws Exception {
        try {
            return this.repositorio.save(datosPelicula);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas las películas
    public List<Pelicula> buscarTodasPeliculas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Pelicula buscarPeliculaPorId(Integer idPelicula) throws Exception {
        try {
            Optional<Pelicula> peliculaBuscada = this.repositorio.findById(idPelicula);
            if (peliculaBuscada.isPresent()) {
                return peliculaBuscada.get();
            } else {
                throw new Exception("Película no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar película
    public Pelicula modificarPelicula(Integer id, Pelicula datosPelicula) throws Exception {
        try {
            Optional<Pelicula> peliculaBuscada = this.repositorio.findById(id);
            if (peliculaBuscada.isPresent()) {
                Pelicula peliculaActualizar = peliculaBuscada.get();
                peliculaActualizar.setTitulo(datosPelicula.getTitulo());
                peliculaActualizar.setSinopsis(datosPelicula.getSinopsis());
                peliculaActualizar.setDuracionMinutos(datosPelicula.getDuracionMinutos());
                peliculaActualizar.setGenero(datosPelicula.getGenero());
                peliculaActualizar.setClasificacion(datosPelicula.getClasificacion());
                peliculaActualizar.setDirector(datosPelicula.getDirector());
                peliculaActualizar.setActores(datosPelicula.getActores());
                peliculaActualizar.setUrlPortada(datosPelicula.getUrlPortada());
                peliculaActualizar.setUrlTrailer(datosPelicula.getUrlTrailer());
                peliculaActualizar.setFechaLanzamiento(datosPelicula.getFechaLanzamiento());
                return this.repositorio.save(peliculaActualizar);
            } else {
                throw new Exception("Película no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar película
    public boolean eliminarPelicula(Integer id) throws Exception {
        try {
            Optional<Pelicula> peliculaBuscada = this.repositorio.findById(id);
            if (peliculaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Película no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
