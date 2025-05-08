package com.example.Backend_RecVelvet.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "horario_tabla")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Integer id;

    @Column(name = "fecha_hora_inicio",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String fechaHoraInicio;

    @Column(name = "fecha_hora_fin",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String fechaHoraFin;

    @Column(name = "precio_general", nullable = false)
    private Double precioGeneral;

    @ManyToOne
    @JoinColumn(name = "fk_pelicula", referencedColumnName = "id_pelicula")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "fk_sala",referencedColumnName = "sala_id")
    private Sala sala;

    public Horario() {
    }

    public Horario(Integer id, String fechaHoraInicio, String fechaHoraFin, Double precioGeneral) {
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

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(String fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Double getPrecioGeneral() {
        return precioGeneral;
    }

    public void setPrecioGeneral(Double precioGeneral) {
        this.precioGeneral = precioGeneral;
    }
}
