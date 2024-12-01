package com.restaurante.saborgourmet.service;

import com.restaurante.saborgourmet.model.Cliente;
import com.restaurante.saborgourmet.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Obtener todos los clientes
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    // Obtener cliente por ID
    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Cliente no encontrado con ID: " + id));
    }

    // Crear o actualizar un cliente
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar cliente por ID
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
