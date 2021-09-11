package com.api.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.application.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	Optional<Cliente> findById(Integer idUsuario);

}
