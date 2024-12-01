package com.restaurante.saborgourmet.service;

import com.restaurante.saborgourmet.model.Reserva;
import com.restaurante.saborgourmet.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Obtener todas las reservas
    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }
    // Crear una nueva reserva
    public Reserva crearReserva(Reserva reserva) {
        if (!esMesaDisponible(reserva.getMesa().getId(), reserva.getFechaHora())) {
            throw new IllegalArgumentException("La mesa no está disponible para el horario solicitado.");
        }
        return reservaRepository.save(reserva);
    }

    // Verificar si una mesa está disponible para una fecha y hora
    public boolean esMesaDisponible(Long mesaId, LocalDateTime fechaHora) {
        List<Reserva> reservas = reservaRepository.findByMesaIdAndFechaHora(mesaId, fechaHora);
        return reservas.isEmpty(); // Disponible si no hay reservas en ese horario
    }
}
