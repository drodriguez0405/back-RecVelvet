package com.example.Backend_RecVelvet.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "horario_tabla")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Integer id;

    @Column(name = "fecha_hora_inicio",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaHoraInicio;

    @Column(name = "fecha_hora_fin",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaHoraFin;

    @Column(name = "precio_general", nullable = false)
    private Double precioGeneral;

    @ManyToOne
    @JoinColumn(name = "fk_pelicula", referencedColumnName = "id_pelicula")
    @JsonBackReference(value = "pelicula-horarios")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "fk_sala",referencedColumnName = "id_sala")
    @JsonBackReference(value = "sala-horarios")
    private Sala sala;

    public Horario() {
    }

    public Horario(Integer id, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Double precioGeneral) {
        this.id = id;
        this.fechaHoraInicio = LocalDate.from(fechaHoraInicio);
        this.fechaHoraFin = LocalDate.from(fechaHoraFin);
        this.precioGeneral = precioGeneral;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio.atStartOfDay();
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = LocalDate.from(fechaHoraInicio);
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin.atStartOfDay();
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = LocalDate.from(fechaHoraFin);
    }

    public Double getPrecioGeneral() {
        return precioGeneral;
    }

    public void setPrecioGeneral(Double precioGeneral) {
        this.precioGeneral = precioGeneral;
    }
}
