package com.api.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.application.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
