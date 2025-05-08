package com.example.Backend_RecVelvet.servicios;

import com.example.Backend_RecVelvet.modelos.ButacaReserva;
import com.example.Backend_RecVelvet.repositorios.IButacaReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ButacaReservaServicio {
    @Autowired
    IButacaReservaRepositorio repositorio;

    // Guardar butaca reservada
    public ButacaReserva guardarButacaReserva(ButacaReserva datosButaca) throws Exception {
        try {
            return this.repositorio.save(datosButaca);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas las butacas reservadas
    public List<ButacaReserva> buscarTodasButacasReservadas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar butaca reservada por ID
    public ButacaReserva buscarButacaReservaPorId(Integer idButaca) throws Exception {
        try {
            Optional<ButacaReserva> butacaBuscada = this.repositorio.findById(idButaca);
            if (butacaBuscada.isPresent()) {
                return butacaBuscada.get();
            } else {
                throw new Exception("Butaca no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar butaca reservada (actualiza todos los campos)
    public ButacaReserva modificarButacaReserva(Integer id, ButacaReserva datosButaca) throws Exception {
        try {
            Optional<ButacaReserva> butacaBuscada = this.repositorio.findById(id);
            if (butacaBuscada.isPresent()) {
                ButacaReserva butacaActualizar = butacaBuscada.get();
                butacaActualizar.setNumeroFila(datosButaca.getNumeroFila());
                butacaActualizar.setNumeroAsiento(datosButaca.getNumeroAsiento());
                return this.repositorio.save(butacaActualizar);
            } else {
                throw new Exception("Butaca no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar butaca reservada
    public boolean eliminarButacaReserva(Integer id) throws Exception {
        try {
            Optional<ButacaReserva> butacaBuscada = this.repositorio.findById(id);
            if (butacaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Butaca no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
