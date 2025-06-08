package com.example.Backend_RecVelvet.controladores;



import com.example.Backend_RecVelvet.dtos.UsuarioDTO;
import com.example.Backend_RecVelvet.modelos.Usuario;

import com.example.Backend_RecVelvet.servicios.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class ControladorUsuario {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(usuarioDTO.getNombre());
            nuevoUsuario.setCorreoElectronico(usuarioDTO.getCorreoElectronico());
            nuevoUsuario.setContrasena(usuarioDTO.getContrasena());
            nuevoUsuario.setUsuarioRol(usuarioDTO.getUsuarioRol());
            nuevoUsuario.setFechaRegistro(usuarioDTO.getFechaRegistro());
            nuevoUsuario.setUltimoLogin(usuarioDTO.getUltimoLogin());

            return new ResponseEntity<>(usuarioServicio.guardarUsuario(nuevoUsuario), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosUsuarios() {
        try {
            return new ResponseEntity<>(usuarioServicio.buscarTodosUsuarios(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(usuarioServicio.buscarUsuarioPorId(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        try {
            return new ResponseEntity<>(usuarioServicio.modificarUsuario(id, usuarioDTO), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) {
        try {
            boolean eliminado = usuarioServicio.eliminarUsuario(id);
            if (eliminado) {
                return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se pudo eliminar el usuario", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
