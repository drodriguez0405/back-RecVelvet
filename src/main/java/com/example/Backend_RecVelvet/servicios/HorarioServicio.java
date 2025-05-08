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

    // Guardar horario
    public Horario guardarHorario(Horario datosHorario) throws Exception {
        try {
            return this.repositorio.save(datosHorario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos los horarios
    public List<Horario> buscarTodosHorarios() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar horario por ID
    public Horario buscarHorarioPorId(Integer idHorario) throws Exception {
        try {
            Optional<Horario> horarioBuscado = this.repositorio.findById(idHorario);
            if (horarioBuscado.isPresent()) {
                return horarioBuscado.get();
            } else {
                throw new Exception("Horario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar horario
    public Horario modificarHorario(Integer id, Horario datosHorario) throws Exception {
        try {
            Optional<Horario> horarioBuscado = this.repositorio.findById(id);
            if (horarioBuscado.isPresent()) {
                Horario horarioActualizar = horarioBuscado.get();
                horarioActualizar.setFechaHoraInicio(datosHorario.getFechaHoraInicio());
                horarioActualizar.setFechaHoraFin(datosHorario.getFechaHoraFin());
                horarioActualizar.setPrecioGeneral(datosHorario.getPrecioGeneral());
                return this.repositorio.save(horarioActualizar);
            } else {
                throw new Exception("Horario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar horario
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
