package com.restaurante.saborgourmet.controller;

import com.restaurante.saborgourmet.model.Mesa;
import com.restaurante.saborgourmet.service.MesaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mesas")
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    // Mostrar formulario para crear una nueva mesa
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaMesa() {
        return "nuevaMesa";
    }

    // Guardar una nueva mesa
    @PostMapping("/guardar")
    public String guardarMesa(@RequestParam int numero,
                              @RequestParam int capacidad) {
        Mesa mesa = new Mesa();
        mesa.setNumero(numero);
        mesa.setCapacidad(capacidad);
        mesaService.guardarMesa(mesa);
        return "redirect:/";
    }
}
