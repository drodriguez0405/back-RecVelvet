package com.example.Backend_RecVelvet.modelos;

import com.example.Backend_RecVelvet.ayudas.enums.UsuarioRolEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario_tabla")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nombre",length = 100,nullable = false)
    private String nombre;

    @Column(name = "correo_electronico",length = 100, unique = true,nullable = false)
    private String correoElectronico;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "fecha_registro", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaRegistro;

    @Column(name = "ultimo_login", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime ultimoLogin;

    @Column(name = "rol_usuario", columnDefinition = "VARCHAR(20) DEFAULT 'CLIENTE'")
    @Enumerated(EnumType.STRING)
    private UsuarioRolEnum usuarioRol;


    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference(value = "usuario-reservas")
    private List<Reserva> reservas;
    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String correoElectronico, String contrasena, LocalDateTime fechaRegistro, LocalDateTime ultimoLogin, UsuarioRolEnum usuarioRol) {
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
