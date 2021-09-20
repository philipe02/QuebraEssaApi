package com.api.application.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.api.application.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Optional<Cliente> findById(Integer idUsuario);

	@Modifying
	@Query(value = "INSERT INTO grupo_confianca (id_confiador,id_confiado) VALUES (?1, ?2)", nativeQuery = true)
	@Transactional
	void addToConfianca(Integer idConfiador, Integer idConfiado);

}
