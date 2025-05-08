package com.example.Backend_RecVelvet.repositorios;

import com.example.Backend_RecVelvet.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer> {
}
