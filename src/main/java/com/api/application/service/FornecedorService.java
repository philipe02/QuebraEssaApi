package com.api.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.application.model.Fornecedor;
import com.api.application.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	FornecedorRepository apiRepository;

	public List<Fornecedor> findAll(String servico, String nome, Float nota, Integer distancia, Integer itensPagina,
			Integer numeroPagina, String direcaoOrdenacao, String campoOrdem) {

		return apiRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> save(Fornecedor fornecedor) {

		return (List<Fornecedor>) apiRepository.save(fornecedor);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> detalhes(String nome){
		
		Object listaDetalhes = apiRepository.findByNome(nome);
		
		return (List<Fornecedor>) listaDetalhes;
	}
}
