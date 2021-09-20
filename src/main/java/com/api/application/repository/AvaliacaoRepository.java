package com.api.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.application.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {

}
