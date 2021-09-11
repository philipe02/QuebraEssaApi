package com.api.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.application.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{

	public List<Fornecedor> findByNome(String nome);
}
