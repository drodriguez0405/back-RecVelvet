package com.example.Backend_RecVelvet.dtos;

import com.example.Backend_RecVelvet.ayudas.enums.UsuarioRolEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaRegistro;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ultimoLogin;

    private UsuarioRolEnum usuarioRol;

    public UsuarioDTO() {}

    public UsuarioDTO(Integer id, String nombre, String correoElectronico, String contrasena,
                      LocalDateTime fechaRegistro, LocalDateTime ultimoLogin, UsuarioRolEnum usuarioRol) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
        this.ultimoLogin = ultimoLogin;
        this.usuarioRol = usuarioRol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public UsuarioRolEnum getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRolEnum usuarioRol) {
        this.usuarioRol = usuarioRol;
    }
}
