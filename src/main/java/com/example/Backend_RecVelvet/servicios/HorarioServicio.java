package com.example.Backend_RecVelvet.servicios;

import com.example.Backend_RecVelvet.dtos.HorarioDTO;
import com.example.Backend_RecVelvet.modelos.Horario;
import com.example.Backend_RecVelvet.modelos.Pelicula;
import com.example.Backend_RecVelvet.modelos.Sala;
import com.example.Backend_RecVelvet.repositorios.IHorarioRepositorio;
import com.example.Backend_RecVelvet.repositorios.IPeliculaRepositorio;
import com.example.Backend_RecVelvet.repositorios.ISalaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServicio {
    @Autowired
    private IHorarioRepositorio repositorio;

    @Autowired
    private IPeliculaRepositorio peliculaRepositorio;

    @Autowired
    private ISalaRepositorio salaRepositorio;

    // Guardar horario con relaciones desde DTO
    public Horario guardarHorario(HorarioDTO datosHorario) throws Exception {
        try {
            Horario nuevoHorario = convertirDtoAEntidad(datosHorario);
            return repositorio.save(nuevoHorario);
        } catch (Exception error) {
            throw new Exception("Error al guardar horario: " + error.getMessage());
        }
    }

    // Buscar todos los registros
    public List<Horario> buscarTodosHorarios() throws Exception {
        try {
            return repositorio.findAll();
        } catch (Exception error) {
            throw new Exception("Error al buscar horarios: " + error.getMessage());
        }
    }

    // Buscar por id
    public Horario buscarHorarioPorId(Integer idHorario) throws Exception {
        return repositorio.findById(idHorario)
                .orElseThrow(() -> new Exception("Horario con ID " + idHorario + " no encontrado"));
    }

    // Modificar horario completo desde DTO
    public Horario modificarHorario(Integer id, HorarioDTO datosHorario) throws Exception {
        try {
            Horario horarioExistente = buscarHorarioPorId(id);
            actualizarEntidadDesdeDto(horarioExistente, datosHorario);
            return repositorio.save(horarioExistente);
        } catch (Exception error) {
            throw new Exception("Error al modificar horario: " + error.getMessage());
        }
    }

    // Eliminar por id
    public void eliminarHorario(Integer id) throws Exception {
        try {
            if (!repositorio.existsById(id)) {
                throw new Exception("Horario con ID " + id + " no encontrado");
            }
            repositorio.deleteById(id);
        } catch (Exception error) {
            throw new Exception("Error al eliminar horario: " + error.getMessage());
        }
    }

    // Métodos auxiliares privados
    private Horario convertirDtoAEntidad(HorarioDTO dto) throws Exception {
        Horario horario = new Horario();
        horario.setFechaHoraInicio(dto.getFechaHoraInicio());
        horario.setFechaHoraFin(dto.getFechaHoraFin());
        horario.setPrecioGeneral(dto.getPrecioGeneral());

        if (dto.getPeliculaId() != null) {
            Pelicula pelicula = peliculaRepositorio.findById(dto.getPeliculaId())
                    .orElseThrow(() -> new Exception("Película con ID " + dto.getPeliculaId() + " no encontrada"));
            horario.setPelicula(pelicula);
        }

        if (dto.getSalaId() != null) {
            Sala sala = salaRepositorio.findById(dto.getSalaId())
                    .orElseThrow(() -> new Exception("Sala con ID " + dto.getSalaId() + " no encontrada"));
            horario.setSala(sala);
        }

        return horario;
    }

    private void actualizarEntidadDesdeDto(Horario horario, HorarioDTO dto) throws Exception {
        horario.setFechaHoraInicio(dto.getFechaHoraInicio());
        horario.setFechaHoraFin(dto.getFechaHoraFin());
        horario.setPrecioGeneral(dto.getPrecioGeneral());

        if (dto.getPeliculaId() != null) {
            Pelicula pelicula = peliculaRepositorio.findById(dto.getPeliculaId())
                    .orElseThrow(() -> new Exception("Película con ID " + dto.getPeliculaId() + " no encontrada"));
            horario.setPelicula(pelicula);
        }

        if (dto.getSalaId() != null) {
            Sala sala = salaRepositorio.findById(dto.getSalaId())
                    .orElseThrow(() -> new Exception("Sala con ID " + dto.getSalaId() + " no encontrada"));
            horario.setSala(sala);
        }
    }
}
