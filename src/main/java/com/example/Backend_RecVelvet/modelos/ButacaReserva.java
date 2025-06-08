package com.example.Backend_RecVelvet.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "butaca_reserva_tabla")
public class ButacaReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_butaca_reserva")
    private Integer id;

    @Column(name = "numero_fila",length = 50, nullable = false)
    private String numeroFila;

    @Column(name = "numero_asiento",length = 10, nullable = false)
    private String numeroAsiento;

    @ManyToOne
    @JoinColumn(name = "fk_reserva", referencedColumnName = "id_reserva")
    @JsonBackReference(value = "reserva-butacas")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "fk_sala", referencedColumnName = "id_sala")
    @JsonBackReference(value = "sala")
    private Sala sala;


    public ButacaReserva(Integer id, String numeroFila, String numeroAsiento) {
        this.id = id;
        this.numeroFila = numeroFila;
        this.numeroAsiento = numeroAsiento;
    }

    public ButacaReserva() {
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
