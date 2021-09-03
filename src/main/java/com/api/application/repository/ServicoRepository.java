package com.api.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.application.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	public List<Servico> findByTitulo(String titulo);
}
