package com.example.Backend_RecVelvet.repositorios;

import com.example.Backend_RecVelvet.modelos.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorarioRepositorio extends JpaRepository<Horario,Integer> {
}
