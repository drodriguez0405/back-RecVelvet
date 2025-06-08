package com.example.Backend_RecVelvet.dtos;

public class ButacaReservaDTO {
    private Integer id;
    private String numeroFila;
    private String numeroAsiento;
    private Integer reservaId;
    private Integer salaId;

    public ButacaReservaDTO() {
    }

    public ButacaReservaDTO(Integer id, String numeroFila, String numeroAsiento, Integer reservaId, Integer salaId) {
        this.id = id;
        this.numeroFila = numeroFila;
        this.numeroAsiento = numeroAsiento;
        this.reservaId = reservaId;
        this.salaId = salaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroFila() {
        return numeroFila;
    }

    public void setNumeroFila(String numeroFila) {
        this.numeroFila = numeroFila;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public Integer getSalaId() {
        return salaId;
    }

    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }
}
