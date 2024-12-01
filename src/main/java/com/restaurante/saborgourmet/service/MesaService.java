package com.restaurante.saborgourmet.service;

import com.restaurante.saborgourmet.model.Mesa;
import com.restaurante.saborgourmet.repository.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    // Obtener todas las mesas
    public List<Mesa> obtenerTodas() {
        return mesaRepository.findAll();
    }

    // Obtener mesa por ID
    public Mesa obtenerPorId(Long id) {
        return mesaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Mesa no encontrada con ID: " + id));
    }

    // Crear o actualizar una mesa
    public Mesa guardarMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    // Eliminar mesa por ID
    public void eliminarMesa(Long id) {
        mesaRepository.deleteById(id);
    }
}
