package com.api.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.application.model.Indicacao;

public interface IndicacaoRepository extends JpaRepository<Indicacao, Integer> {

}
