package com.api.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.api.application.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>, JpaSpecificationExecutor<Fornecedor> {

	public List<Fornecedor> findByNome(String nome);
}
