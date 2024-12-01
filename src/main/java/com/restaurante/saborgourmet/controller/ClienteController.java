package com.restaurante.saborgourmet.controller;

import com.restaurante.saborgourmet.model.Cliente;
import com.restaurante.saborgourmet.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Mostrar formulario para crear un nuevo cliente
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCliente() {
        return "nuevoCliente";
    }

    // Guardar un nuevo cliente
    @PostMapping("/guardar")
    public String guardarCliente(@RequestParam String nombre,
                                 @RequestParam String correo,
                                 @RequestParam String telefono) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        clienteService.guardarCliente(cliente);
        return "redirect:/";
    }
}
