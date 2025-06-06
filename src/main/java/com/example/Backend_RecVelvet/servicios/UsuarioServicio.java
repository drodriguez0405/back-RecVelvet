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

    //guardar
    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        try {
            //validar los datos de entrada
            return this.repositorio.save(usuario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos los registros
    public List<Usuario> buscarTodosUsuarios() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar por id
    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
        try {
            Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()) {
                return usuarioBuscado.get();
            } else {
                throw new Exception("El usuario consultado no está en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //modificar por id
    public Usuario modificarUsuario(Integer id, Usuario datosUsuario) throws Exception {
        try {
            Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()) {
                usuarioBuscado.get().setNombre(datosUsuario.getNombre());
                usuarioBuscado.get().setCorreoElectronico(datosUsuario.getCorreoElectronico());
                usuarioBuscado.get().setContrasena(datosUsuario.getContrasena());
                usuarioBuscado.get().setUsuarioRol(datosUsuario.getUsuarioRol());
                usuarioBuscado.get().setFechaRegistro(datosUsuario.getFechaRegistro());
                usuarioBuscado.get().setUltimoLogin(datosUsuario.getUltimoLogin());
                return this.repositorio.save(usuarioBuscado.get());
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //eliminar por id
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
