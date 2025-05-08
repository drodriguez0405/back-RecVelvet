package com.example.Backend_RecVelvet.modelos;

import com.example.Backend_RecVelvet.ayudas.enums.UsuarioRolEnum;
import jakarta.persistence.*;

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

    @Column(name = "correo_electronico", nullable = false, length = 100, unique = true)
    private String correoElectronico;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "fecha_registro", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String fechaRegistro;

    @Column(name = "ultimo_login")
    private String ultimoLogin;

    @Column(name = "rol_usuario", nullable = false)
    private UsuarioRolEnum usuarioRol;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;
    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String correoElectronico, String contrasena, String fechaRegistro, String ultimoLogin, UsuarioRolEnum usuarioRol) {
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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(String ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public UsuarioRolEnum getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRolEnum usuarioRol) {
        this.usuarioRol = usuarioRol;
    }
}
