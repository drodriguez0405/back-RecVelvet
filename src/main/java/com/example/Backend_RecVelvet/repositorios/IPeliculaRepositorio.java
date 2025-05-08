package com.example.Backend_RecVelvet.repositorios;

import com.example.Backend_RecVelvet.modelos.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepositorio extends JpaRepository<Pelicula, Integer> {
}
