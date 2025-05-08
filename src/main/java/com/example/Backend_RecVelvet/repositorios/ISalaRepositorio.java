package com.example.Backend_RecVelvet.repositorios;

import com.example.Backend_RecVelvet.modelos.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaRepositorio extends JpaRepository<Sala, Integer> {
}
