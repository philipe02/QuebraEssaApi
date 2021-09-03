package com.api.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.application.model.Fornecedor;
import com.api.application.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	FornecedorRepository apiRepository;

	public List<Fornecedor> findAll(Integer id) {
		
		return apiRepository.findAll(); 
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> save(Fornecedor fornecedor) {
		
		return (List<Fornecedor>) apiRepository.save(fornecedor);
	}
}
