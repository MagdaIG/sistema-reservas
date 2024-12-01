package com.restaurante.saborgourmet.repository;

import com.restaurante.saborgourmet.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // Buscar reservas de una mesa en un horario específico
    List<Reserva> findByMesaIdAndFechaHora(Long mesaId, LocalDateTime fechaHora);
}
