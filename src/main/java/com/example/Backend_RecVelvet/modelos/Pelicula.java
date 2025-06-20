package com.example.Backend_RecVelvet.modelos;

import com.example.Backend_RecVelvet.ayudas.enums.EstadoPeliculaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pelicula_tabla")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer id;

    @Column(name = "titulo", length = 150,nullable = false)
    private String titulo;

    @Column(name = "sinopsis", length = 150,nullable = false)
    private String sinopsis;

    @Column(name = "duracion_minutos")
    private Integer duracionMinutos;

    @Column(name = "genero" ,length = 50,nullable = false)
    private String genero;

    @Column(name = "clasificacion", length = 10,nullable = false )
    private String clasificacion;

    @Column(name = "director" , length = 100, nullable = false)
    private String director;

    @Column(name = "actores", length = 100 ,nullable = false )
    private String actores;

    @Column(name = "url_portada" , length = 150, nullable = false)
    private String urlPortada;

    @Column(name = "url_trailer", length = 185,nullable = false )
    private String urlTrailer;

    @Column(name = "fecha_entrega",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaLanzamiento;


    @Column(name = "estado" ,columnDefinition = "VARCHAR(40) DEFAULT 'ESTRENO'")
    @Enumerated(EnumType.STRING)
    private EstadoPeliculaEnum estadoPelicula;

    @OneToMany(mappedBy = "pelicula")
    @JsonManagedReference(value = "pelicula-horarios")
    private List<Horario> horarios;

    public Pelicula() {
    }

    public Pelicula(Integer id, String titulo, String sinopsis, Integer duracionMinutos, String genero, String clasificacion, String director, String actores, String urlPortada, String urlTrailer, LocalDateTime fechaLanzamiento) {
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

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
