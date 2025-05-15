package com.example.Backend_RecVelvet.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sala_tabla")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @OneToMany(mappedBy = "sala")
    @JsonManagedReference(value = "sala-horarios")
    private List<Horario> horarios;

    @OneToMany(mappedBy = "sala")
    @JsonManagedReference(value = "sala-butacas")
    private List<ButacaReserva> butacasReservadas;

    public Sala() {
    }

    public Sala(Integer id, String nombre, int capacidad, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
