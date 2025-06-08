package com.example.Backend_RecVelvet.dtos;

import java.util.List;

public class SalaDTO {
    private Integer id;
    private String nombre;
    private Integer capacidad;
    private String descripcion;
    private List<Integer> horariosIds;
    private List<Integer> butacasReservadasIds;

    public SalaDTO() {}

    public SalaDTO(Integer id, String nombre, Integer capacidad, String descripcion,
                   List<Integer> horariosIds, List<Integer> butacasReservadasIds) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.horariosIds = horariosIds;
        this.butacasReservadasIds = butacasReservadasIds;
    }

    // Getters y Setters
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

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Integer> getHorariosIds() {
        return horariosIds;
    }

    public void setHorariosIds(List<Integer> horariosIds) {
        this.horariosIds = horariosIds;
    }

    public List<Integer> getButacasReservadasIds() {
        return butacasReservadasIds;
    }

    public void setButacasReservadasIds(List<Integer> butacasReservadasIds) {
        this.butacasReservadasIds = butacasReservadasIds;
    }
}
