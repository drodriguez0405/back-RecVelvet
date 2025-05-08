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

    // Guardar sala
    public Sala guardarSala(Sala datosSala) throws Exception {
        try {
            return this.repositorio.save(datosSala);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas las salas
    public List<Sala> buscarTodasSalas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar sala por ID
    public Sala buscarSalaPorId(Integer idSala) throws Exception {
        try {
            Optional<Sala> salaBuscada = this.repositorio.findById(idSala);
            if (salaBuscada.isPresent()) {
                return salaBuscada.get();
            } else {
                throw new Exception("Sala no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar sala (actualiza todos los campos)
    public Sala modificarSala(Integer id, Sala datosSala) throws Exception {
        try {
            Optional<Sala> salaBuscada = this.repositorio.findById(id);
            if (salaBuscada.isPresent()) {
                Sala salaActualizar = salaBuscada.get();
                salaActualizar.setNombre(datosSala.getNombre());
                salaActualizar.setCapacidad(datosSala.getCapacidad());
                salaActualizar.setDescripcion(datosSala.getDescripcion());
                return this.repositorio.save(salaActualizar);
            } else {
                throw new Exception("Sala no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar sala
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
