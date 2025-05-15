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

    //guardar
    public ButacaReserva guardarButacaReserva(ButacaReserva datosButaca) throws Exception {
        try {
            //validar los datos de entrada
            return this.repositorio.save(datosButaca);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos los registros
    public List<ButacaReserva> buscarTodasButacasReservadas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar por id
    public ButacaReserva buscarButacaReservaPorId(Integer idButaca) throws Exception {
        try {
            Optional<ButacaReserva> butacaBuscada = this.repositorio.findById(idButaca);
            if (butacaBuscada.isPresent()) {
                return butacaBuscada.get();
            } else {
                throw new Exception("La butaca reservada consultada no está en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //modificar por id
    public ButacaReserva modificarButacaReserva(Integer id, ButacaReserva datosButaca) throws Exception {
        try {
            Optional<ButacaReserva> butacaBuscada = this.repositorio.findById(id);
            if (butacaBuscada.isPresent()) {
                butacaBuscada.get().setNumeroFila(datosButaca.getNumeroFila());
                butacaBuscada.get().setNumeroAsiento(datosButaca.getNumeroAsiento());
                return this.repositorio.save(butacaBuscada.get());
            } else {
                throw new Exception("Butaca reservada no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //eliminar por id
    public boolean eliminarButacaReserva(Integer id) throws Exception {
        try {
            Optional<ButacaReserva> butacaBuscada = this.repositorio.findById(id);
            if (butacaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Butaca reservada no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
