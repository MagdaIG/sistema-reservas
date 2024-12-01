package com.restaurante.saborgourmet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/saludo")
    public String saludo() {
        return "¡Bienvenido a mi aplicación Spring Boot!";
    }
}
