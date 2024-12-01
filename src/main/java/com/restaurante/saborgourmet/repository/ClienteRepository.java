package com.restaurante.saborgourmet.repository;

import com.restaurante.saborgourmet.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}