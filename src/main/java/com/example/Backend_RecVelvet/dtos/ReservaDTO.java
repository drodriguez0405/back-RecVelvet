package com.example.Backend_RecVelvet.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ReservaDTO {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaReserva;

    private String codigoReserva;
    private String totalPagado;
    private String estadoPago;
    private String metodoPago;
    private String transaccionId;
    private Integer usuarioId;  // FK
    private Integer horarioId;  // FK

    // Constructores
    public ReservaDTO() {}

    public ReservaDTO(Integer id, LocalDateTime fechaReserva, String codigoReserva,
                      String totalPagado, String estadoPago, String metodoPago,
                      String transaccionId, Integer usuarioId, Integer horarioId) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.codigoReserva = codigoReserva;
        this.totalPagado = totalPagado;
        this.estadoPago = estadoPago;
        this.metodoPago = metodoPago;
        this.transaccionId = transaccionId;
        this.usuarioId = usuarioId;
        this.horarioId = horarioId;
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

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Integer horarioId) {
        this.horarioId = horarioId;
    }
}
