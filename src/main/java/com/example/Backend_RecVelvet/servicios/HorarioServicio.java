package com.example.Backend_RecVelvet.servicios;

import com.example.Backend_RecVelvet.modelos.Horario;
import com.example.Backend_RecVelvet.repositorios.IHorarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServicio {
    @Autowired
    IHorarioRepositorio repositorio;

    //guardar
    public Horario guardarHorario(Horario datosHorario) throws Exception {
        try {
            //validar los datos de entrada
            return this.repositorio.save(datosHorario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos los registros
    public List<Horario> buscarTodosHorarios() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar por id
    public Horario buscarHorarioPorId(Integer idHorario) throws Exception {
        try {
            Optional<Horario> horarioBuscado = this.repositorio.findById(idHorario);
            if (horarioBuscado.isPresent()) {
                return horarioBuscado.get();
            } else {
                throw new Exception("El horario consultado no está en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //modificar por id
    public Horario modificarHorario(Integer id, Horario datosHorario) throws Exception {
        try {
            Optional<Horario> horarioBuscado = this.repositorio.findById(id);
            if (horarioBuscado.isPresent()) {
                horarioBuscado.get().setFechaHoraInicio(datosHorario.getFechaHoraInicio());
                horarioBuscado.get().setFechaHoraFin(datosHorario.getFechaHoraFin());
                horarioBuscado.get().setPrecioGeneral(datosHorario.getPrecioGeneral());
                return this.repositorio.save(horarioBuscado.get());
            } else {
                throw new Exception("Horario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //eliminar por id
    public boolean eliminarHorario(Integer id) throws Exception {
        try {
            Optional<Horario> horarioBuscado = this.repositorio.findById(id);
            if (horarioBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Horario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
