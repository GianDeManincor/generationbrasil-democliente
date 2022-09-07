package com.generation.brasil.demo.v1.repository;

import com.generation.brasil.demo.v1.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
}
