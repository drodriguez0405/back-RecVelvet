package com.example.Backend_RecVelvet.servicios;

import com.example.Backend_RecVelvet.dtos.UsuarioDTO;
import com.example.Backend_RecVelvet.modelos.Usuario;
import com.example.Backend_RecVelvet.repositorios.IUsuarioRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private IUsuarioRepositorio repositorio;

    public Usuario guardarUsuario(Usuario datosUsuario) throws Exception {
        try {
            validarUsuario(datosUsuario);
            return this.repositorio.save(datosUsuario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Usuario> buscarTodosUsuarios() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
        try {
            Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()) {
                return usuarioBuscado.get();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Usuario modificarUsuario(Integer id, UsuarioDTO datosUsuario) throws Exception {
        try {
            Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()) {
                Usuario usuarioActualizar = usuarioBuscado.get();

                if (datosUsuario.getNombre() != null) {
                    usuarioActualizar.setNombre(datosUsuario.getNombre());
                }
                if (datosUsuario.getCorreoElectronico() != null) {
                    usuarioActualizar.setCorreoElectronico(datosUsuario.getCorreoElectronico());
                }
                if (datosUsuario.getContrasena() != null) {
                    usuarioActualizar.setContrasena(datosUsuario.getContrasena());
                }
                if (datosUsuario.getUsuarioRol() != null) {
                    usuarioActualizar.setUsuarioRol(datosUsuario.getUsuarioRol());
                }

                return this.repositorio.save(usuarioActualizar);
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

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

    private void validarUsuario(Usuario usuario) throws Exception {
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre es obligatorio");
        }
        if (usuario.getCorreoElectronico() == null || usuario.getCorreoElectronico().trim().isEmpty()) {
            throw new Exception("El correo electrónico es obligatorio");
        }
        if (usuario.getContrasena() == null || usuario.getContrasena().trim().isEmpty()) {
            throw new Exception("La contraseña es obligatoria");
        }
    }
}
