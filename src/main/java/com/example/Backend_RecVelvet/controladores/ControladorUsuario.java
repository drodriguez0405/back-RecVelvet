package com.example.Backend_RecVelvet.controladores;

import com.example.Backend_RecVelvet.modelos.Usuario;
import com.example.Backend_RecVelvet.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {

    @Autowired
    UsuarioServicio usuarioServicio;

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario datosUsuario) {
        System.out.println("Entrando a guardarUsuario");
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.usuarioServicio.guardarUsuario(datosUsuario));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar todos
    @GetMapping
    public ResponseEntity<?> buscarTodosUsuarios() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.buscarTodosUsuarios());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.buscarUsuarioPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable Integer id, @RequestBody Usuario datosUsuario) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.modificarUsuario(id, datosUsuario));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.eliminarUsuario(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
