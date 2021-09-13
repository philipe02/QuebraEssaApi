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

	public Page<FornecedorDTO> findAll(String servico, String nome, Double nota, Integer distancia, Integer itensPagina,
			Integer numeroPagina, String direcaoOrdenacao, String campoOrdem) {
		PageRequest pageRequest = PageRequest.of(numeroPagina, itensPagina, Sort.Direction.valueOf(direcaoOrdenacao),
				campoOrdem);

		FornecedorSpecification specFornecedor = new FornecedorSpecification(nome, servico);
		Page<Fornecedor> pageFornecedor = (Page<Fornecedor>) fornecedorRepository.findAll(specFornecedor, pageRequest);

		List<FornecedorDTO> fornecedoresDTO = pageFornecedor.stream()
				.map(fornecedor -> FornecedorDTO.createFornecedorDTO(fornecedor)).collect(Collectors.toList());
		if (nota != null) {
			fornecedoresDTO = fornecedoresDTO.stream().filter(fornecedor -> fornecedor.getNota() > nota)
					.collect(Collectors.toList());
		}
		int totalElements = fornecedoresDTO.size();

		return new PageImpl<FornecedorDTO>(fornecedoresDTO, pageRequest, totalElements);
	}

	public Fornecedor save(Fornecedor fornecedor) {

		return fornecedorRepository.save(fornecedor);
	}

	public Fornecedor detalharFornecedor(Integer idFornecedor) {

		Fornecedor fornecedor = fornecedorRepository.getById(idFornecedor);

		return fornecedor;
	}
}
