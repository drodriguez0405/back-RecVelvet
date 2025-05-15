package com.example.Backend_RecVelvet.modelos;

import com.example.Backend_RecVelvet.ayudas.enums.UsuarioRolEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuario_tabla")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "correo_electronico",length = 100, unique = true,nullable = false)
    private String correoElectronico;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "fecha_registro", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaRegistro;

    @Column(name = "ultimo_login", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate ultimoLogin;

    @Enumerated(EnumType.STRING)
    //@Column(name = "rol_usuario")
    private UsuarioRolEnum usuarioRol;


    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference(value = "usuario-reservas")
    private List<Reserva> reservas;
    public Usuario() {
    }

    public Usuario(String nombre, String correoElectronico, String contrasena, UsuarioRolEnum usuarioRol) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.usuarioRol = usuarioRol;
        this.fechaRegistro = LocalDate.now();
        this.ultimoLogin = LocalDate.now();
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

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDate ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public UsuarioRolEnum getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRolEnum usuarioRol) {
        this.usuarioRol = usuarioRol;
    }
}
