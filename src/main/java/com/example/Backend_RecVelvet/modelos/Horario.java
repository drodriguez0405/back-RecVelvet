package com.example.Backend_RecVelvet.modelos;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "horario_tabla")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Integer id;

    @Column(name = "fecha_hora_inicio",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_fin",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaHoraFin;

    @Column(name = "precio_general", nullable = false)
    private Double precioGeneral;

    @ManyToOne
    @JoinColumn(name = "fk_pelicula", referencedColumnName = "id_pelicula")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "fk_sala",referencedColumnName = "id_sala")
    private Sala sala;

    public Horario() {
    }

    public Horario(Integer id, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Double precioGeneral) {
        this.id = id;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.precioGeneral = precioGeneral;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Double getPrecioGeneral() {
        return precioGeneral;
    }

    public void setPrecioGeneral(Double precioGeneral) {
        this.precioGeneral = precioGeneral;
    }
}
