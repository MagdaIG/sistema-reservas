package com.restaurante.saborgourmet.controller;

import com.restaurante.saborgourmet.model.Cliente;
import com.restaurante.saborgourmet.model.Mesa;
import com.restaurante.saborgourmet.model.Reserva;
import com.restaurante.saborgourmet.service.ClienteService;
import com.restaurante.saborgourmet.service.MesaService;
import com.restaurante.saborgourmet.service.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final ClienteService clienteService;
    private final MesaService mesaService;

    public ReservaController(ReservaService reservaService, ClienteService clienteService, MesaService mesaService) {
        this.reservaService = reservaService;
        this.clienteService = clienteService;
        this.mesaService = mesaService;
    }

    // Mostrar el formulario para nueva reserva
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaReserva(Model model) {
        model.addAttribute("clientes", clienteService.obtenerTodos());
        model.addAttribute("mesas", mesaService.obtenerTodas());
        return "nuevaReserva";
    }

    @PostMapping("/guardar")
    public String guardarReserva(
            @RequestParam Long clienteId, // Recibe el ID del cliente desde el formulario
            @RequestParam Long mesaId, // Recibe el ID de la mesa desde el formulario
            @RequestParam String fechaHora, // Recibe la fecha y hora como String
            Model model) {
        try {
            // Obtener Cliente y Mesa
            Cliente cliente = clienteService.obtenerPorId(clienteId);
            Mesa mesa = mesaService.obtenerPorId(mesaId);

            // Crear la reserva
            Reserva reserva = new Reserva();
            reserva.setCliente(cliente);
            reserva.setMesa(mesa);

            // Convertir el String `fechaHora` a LocalDateTime
            reserva.setFechaHora(LocalDateTime.parse(fechaHora, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            reserva.setEstado("Confirmada");

            // Guardar la reserva en la base de datos
            reservaService.crearReserva(reserva);

            return "redirect:/"; // Redirigir al listado de reservas
        } catch (Exception e) {
            // Manejar errores
            model.addAttribute("error", "Error al guardar la reserva: " + e.getMessage());
            return "nuevaReserva"; // Volver al formulario con el mensaje de error
        }
    }

    // Listar todas las reservas
    @GetMapping("/listar")
    public String listarReservas(Model model) {
        model.addAttribute("reservas", reservaService.obtenerTodas()); // Agrega las reservas al modelo
        return "listarReservas";
    }
}
