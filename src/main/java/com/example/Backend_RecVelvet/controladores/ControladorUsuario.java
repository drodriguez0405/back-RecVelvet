package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.modelos.Usuario;
import com.example.Backend_RecVelvet.servicios.UsuarioServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControladorUsuario {

    @Autowired
    UsuarioServicio servicio;

    @PostMapping(path = "/usuarios",
            consumes = "application/json",  // ¡Sin MediaType!
            produces = "application/json")
    public ResponseEntity<?> guardarUsuario(@Valid @RequestBody Usuario usuario) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardarUsuario(usuario));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarTodosUsuarios() {
        try {
            return ResponseEntity.ok(servicio.buscarTodosUsuarios());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(servicio.buscarUsuarioPorId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modificarUsuario(@PathVariable Integer id, @Valid @RequestBody Usuario datosUsuario) {
        try {
            return ResponseEntity.ok(servicio.modificarUsuario(id, datosUsuario));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) {
        try {
            servicio.eliminarUsuario(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
