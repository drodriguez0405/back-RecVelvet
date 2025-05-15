package com.example.Backend_RecVelvet.servicios;


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


    //guardar
    public Pelicula guardarPelicula(Pelicula datosPelicula)throws Exception{
        try{
            //validar los datos de entrada
            return this.repositorio.save(datosPelicula);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //buscar todos los registros
    public List<Pelicula> buscarTodasPeliculas()throws Exception{
        try{
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //buscar por id
    public Pelicula buscarPeliculaPorId(Integer idPelicula)throws Exception{
        try{
            Optional<Pelicula> peliculaBuscada=this.repositorio.findById(idPelicula);
            if (peliculaBuscada.isPresent()){
                return peliculaBuscada.get();
            }else {
                throw new Exception("La película consultada no esta en BD");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //modificar por id
    public Pelicula modificarPelicula(Integer id, Pelicula datosPelicula) throws Exception{
        try{
            Optional<Pelicula> peliculaBuscada = this.repositorio.findById(id);
            if (peliculaBuscada.isPresent()){
                peliculaBuscada.get().setTitulo(datosPelicula.getTitulo());
                peliculaBuscada.get().setSinopsis(datosPelicula.getSinopsis());
                peliculaBuscada.get().setDuracionMinutos(datosPelicula.getDuracionMinutos());
                peliculaBuscada.get().setGenero(datosPelicula.getGenero());
                peliculaBuscada.get().setClasificacion(datosPelicula.getClasificacion());
                peliculaBuscada.get().setDirector(datosPelicula.getDirector());
                peliculaBuscada.get().setActores(datosPelicula.getActores());
                peliculaBuscada.get().setUrlPortada(datosPelicula.getUrlPortada());
                peliculaBuscada.get().setUrlTrailer(datosPelicula.getUrlTrailer());
                peliculaBuscada.get().setFechaLanzamiento(datosPelicula.getFechaLanzamiento());
                peliculaBuscada.get().setEstadoPelicula(datosPelicula.getEstadoPelicula());
                return this.repositorio.save(peliculaBuscada.get());
            }else{
                throw new Exception("Película no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //eliminar por id
    public boolean eliminarPelicula(Integer id) throws Exception{
        try{
            Optional<Pelicula> peliculaBuscada=this.repositorio.findById(id);
            if (peliculaBuscada.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Película no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}

