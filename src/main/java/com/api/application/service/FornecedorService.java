package com.api.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.application.dto.FornecedorDTO;
import com.api.application.model.Fornecedor;
import com.api.application.repository.FornecedorRepository;
import com.api.application.specification.FornecedorSpecification;

@Service
public class FornecedorService {

	@Autowired
	FornecedorRepository fornecedorRepository;

	public Page<FornecedorDTO> findAll(String servico, String nome, Float nota, Integer distancia, Integer itensPagina,
			Integer numeroPagina, String direcaoOrdenacao, String campoOrdem) {
		PageRequest pageRequest = PageRequest.of(numeroPagina, itensPagina, Sort.Direction.valueOf(direcaoOrdenacao),
				campoOrdem);

		FornecedorSpecification specFornecedor = new FornecedorSpecification(servico, nome);
		Page<Fornecedor> pageFornecedor = (Page<Fornecedor>) fornecedorRepository.findAll(specFornecedor, pageRequest);
		
		List<FornecedorDTO> fornecedoresDTO = pageFornecedor.stream()
				.map(fornecedor -> FornecedorDTO.createFornecedorDTO(fornecedor)).collect(Collectors.toList());

		List<FornecedorDTO> listaFiltradaFornecedor = fornecedoresDTO.stream().filter(fornecedor -> fornecedor.getNota() > nota).collect(Collectors.toList());
		
		int totalElements = listaFiltradaFornecedor.size();

		return new PageImpl<FornecedorDTO>(listaFiltradaFornecedor, pageRequest, totalElements);
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> save(Fornecedor fornecedor) {

		return (List<Fornecedor>) fornecedorRepository.save(fornecedor);
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> detalhes(String nome) {

		Object listaDetalhes = fornecedorRepository.findByNome(nome);

		return (List<Fornecedor>) listaDetalhes;
	}
}
