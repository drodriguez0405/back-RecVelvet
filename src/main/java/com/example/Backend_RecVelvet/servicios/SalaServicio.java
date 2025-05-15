package com.example.Backend_RecVelvet.servicios;

import com.example.Backend_RecVelvet.modelos.Sala;
import com.example.Backend_RecVelvet.repositorios.ISalaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaServicio {
    @Autowired
    ISalaRepositorio repositorio;

    //guardar
    public Sala guardarSala(Sala datosSala) throws Exception {
        try {
            //validar los datos de entrada
            return this.repositorio.save(datosSala);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos los registros
    public List<Sala> buscarTodasSalas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar por id
    public Sala buscarSalaPorId(Integer idSala) throws Exception {
        try {
            Optional<Sala> salaBuscada = this.repositorio.findById(idSala);
            if (salaBuscada.isPresent()) {
                return salaBuscada.get();
            } else {
                throw new Exception("La sala consultada no está en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //modificar por id
    public Sala modificarSala(Integer id, Sala datosSala) throws Exception {
        try {
            Optional<Sala> salaBuscada = this.repositorio.findById(id);
            if (salaBuscada.isPresent()) {
                salaBuscada.get().setNombre(datosSala.getNombre());
                salaBuscada.get().setCapacidad(datosSala.getCapacidad());
                salaBuscada.get().setDescripcion(datosSala.getDescripcion());
                return this.repositorio.save(salaBuscada.get());
            } else {
                throw new Exception("Sala no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //eliminar por id
    public boolean eliminarSala(Integer id) throws Exception {
        try {
            Optional<Sala> salaBuscada = this.repositorio.findById(id);
            if (salaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Sala no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
