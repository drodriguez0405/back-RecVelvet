package com.example.Backend_RecVelvet.servicios;

import com.example.Backend_RecVelvet.modelos.Usuario;
import com.example.Backend_RecVelvet.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    IUsuarioRepositorio repositorio;

    // Guardar usuario
    public Usuario guardarUsuario(Usuario datosUsuario) throws Exception {
        try {
            return this.repositorio.save(datosUsuario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos los usuarios
    public List<Usuario> buscarTodosUsuarios() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar usuario por ID
    public Usuario buscarUsuarioPorId(Integer idUsuario) throws Exception {
        try {
            Optional<Usuario> usuarioBuscado = this.repositorio.findById(idUsuario);
            if (usuarioBuscado.isPresent()) {
                return usuarioBuscado.get();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar usuario (actualiza TODOS los campos)
    public Usuario modificarUsuario(Integer id, Usuario datosUsuario) throws Exception {
        try {
            Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()) {
                Usuario usuarioActualizar = usuarioBuscado.get();
                usuarioActualizar.setNombre(datosUsuario.getNombre());
                usuarioActualizar.setCorreoElectronico(datosUsuario.getCorreoElectronico());
                usuarioActualizar.setContrasena(datosUsuario.getContrasena());
                usuarioActualizar.setUsuarioRol(datosUsuario.getUsuarioRol());
                usuarioActualizar.setFechaRegistro(datosUsuario.getFechaRegistro());
                usuarioActualizar.setUltimoLogin(datosUsuario.getUltimoLogin());
                return this.repositorio.save(usuarioActualizar);
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar usuario
    public boolean eliminarUsuario(Integer id) throws Exception {
        try {
            Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
