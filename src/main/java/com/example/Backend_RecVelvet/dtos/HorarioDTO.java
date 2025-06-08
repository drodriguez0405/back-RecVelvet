package com.example.Backend_RecVelvet.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HorarioDTO {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaHoraInicio;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaHoraFin;

    private BigDecimal precioGeneral;
    private Integer peliculaId;
    private Integer salaId;

    public HorarioDTO() {
    }

    public HorarioDTO(Integer id, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, BigDecimal precioGeneral, Integer peliculaId, Integer salaId) {
        this.id = id;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.precioGeneral = precioGeneral;
        this.peliculaId = peliculaId;
        this.salaId = salaId;
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

    public BigDecimal getPrecioGeneral() {
        return precioGeneral;
    }

    public void setPrecioGeneral(BigDecimal precioGeneral) {
        this.precioGeneral = precioGeneral;
    }

    public Integer getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Integer peliculaId) {
        this.peliculaId = peliculaId;
    }

    public Integer getSalaId() {
        return salaId;
    }

    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }
}
