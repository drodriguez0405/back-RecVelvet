package com.example.Backend_RecVelvet.servicios;


import com.example.Backend_RecVelvet.dtos.PeliculaDTO;
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

    // Guardar película
    public Pelicula guardarPelicula(Pelicula datosPelicula) throws Exception {
        try {
            validarDatosBasicos(datosPelicula);
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
            throw new Exception("Error al buscar películas: " + error.getMessage());
        }
    }

    // Buscar por ID
    public Pelicula buscarPeliculaPorId(Integer idPelicula) throws Exception {
        try {
            Optional<Pelicula> peliculaBuscada = this.repositorio.findById(idPelicula);
            if (peliculaBuscada.isPresent()) {
                return peliculaBuscada.get();
            } else {
                throw new Exception("Película con ID " + idPelicula + " no encontrada");
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

                // Actualizar solo los campos que vienen en el objeto
                if (datosPelicula.getTitulo() != null) {
                    peliculaActualizar.setTitulo(datosPelicula.getTitulo());
                }
                if (datosPelicula.getSinopsis() != null) {
                    peliculaActualizar.setSinopsis(datosPelicula.getSinopsis());
                }
                if (datosPelicula.getDuracionMinutos() != null) {
                    peliculaActualizar.setDuracionMinutos(datosPelicula.getDuracionMinutos());
                }
                // ... Repetir para todos los campos que se deben actualizar

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

    // Validaciones básicas
    private void validarDatosBasicos(Pelicula pelicula) throws Exception {
        if (pelicula.getTitulo() == null || pelicula.getTitulo().trim().isEmpty()) {
            throw new Exception("El título es obligatorio");
        }
        if (pelicula.getDuracionMinutos() != null && pelicula.getDuracionMinutos() <= 0) {
            throw new Exception("La duración debe ser mayor a 0 minutos");
        }
    }
}

