package com.example.Backend_RecVelvet.dtos;

import com.example.Backend_RecVelvet.ayudas.enums.EstadoPeliculaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PeliculaDTO {
    private Integer id;
    private String titulo;
    private String sinopsis;
    private Integer duracionMinutos;
    private String genero;
    private String clasificacion;
    private String director;
    private String actores;
    private String urlPortada;
    private String urlTrailer;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaLanzamiento;

    private EstadoPeliculaEnum estadoPelicula;

    public PeliculaDTO() {
    }

    public PeliculaDTO(Integer id, String titulo, String sinopsis, Integer duracionMinutos, String genero, String clasificacion, String director, String actores, String urlPortada, String urlTrailer, LocalDateTime fechaLanzamiento, EstadoPeliculaEnum estadoPelicula) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.director = director;
        this.actores = actores;
        this.urlPortada = urlPortada;
        this.urlTrailer = urlTrailer;
        this.fechaLanzamiento = fechaLanzamiento;
        this.estadoPelicula = estadoPelicula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }

    public LocalDateTime getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDateTime fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public EstadoPeliculaEnum getEstadoPelicula() {
        return estadoPelicula;
    }

    public void setEstadoPelicula(EstadoPeliculaEnum estadoPelicula) {
        this.estadoPelicula = estadoPelicula;
    }
}
