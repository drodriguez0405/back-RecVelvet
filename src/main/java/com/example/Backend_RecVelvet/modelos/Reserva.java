package com.example.Backend_RecVelvet.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reserva_tabla")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer id;

    @Column(name = "fecha_reserva", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaReserva;

    @Column(name = "codigo_reserva", unique = true, nullable = false)
    private String codigoReserva;

    @Column(name = "total_pagado", nullable = false)
    private String totalPagado;

    @Column(name = "estado_pago", nullable = false)
    private String estadoPago;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    @Column(name = "transaccion_id", unique = true)
    private String transaccionId;


    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference(value = "usuario-reservas")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_horario", referencedColumnName = "id_horario")
    @JsonManagedReference(value = "horario-reservas")
    private Horario horario;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "reserva-butacas")
    private List<ButacaReserva> butacaReservas;
    public Reserva() {
    }

    public Reserva(Integer id, LocalDateTime fechaReserva, String codigoReserva, String totalPagado, String estadoPago, String metodoPago, String transaccionId) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.codigoReserva = codigoReserva;
        this.totalPagado = totalPagado;
        this.estadoPago = estadoPago;
        this.metodoPago = metodoPago;
        this.transaccionId = transaccionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(String totalPagado) {
        this.totalPagado = totalPagado;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<ButacaReserva> getButacaReservas() {
        return butacaReservas;
    }

    public void setButacaReservas(List<ButacaReserva> butacaReservas) {
        this.butacaReservas = butacaReservas;
    }

}
