package com.api.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.api.application.dto.ServicoDTO;
import com.api.application.exception.StandardException;
import com.api.application.model.Servico;
import com.api.application.repository.ServicoRepository;
import com.api.application.specification.ServicoSpecification;

@Service
public class ServicoService {

	@Autowired
	ServicoRepository servicoRepo;

	public Servico save(Servico servico) throws Exception {
		Servico servicoSalvo = new Servico();
		try {
			servicoSalvo = servicoRepo.save(servico);
		} catch (Exception e) {
			throw new StandardException(e);
		}
		return servicoSalvo;
	}
	public Page<Servico> buscarTodos(Integer numeroPagina, 
		Integer itensPorPagina, 
		String campoOrdenacao, 
		String ordemOrdenacao,
		Integer id, String titulo){

			ServicoSpecification specServico = new ServicoSpecification(id, titulo);
			
			//Criação do objeto PageRequest responsável por conter os parâmetros de ordenação e paginação
			PageRequest pageRequest = PageRequest.of(numeroPagina, itensPorPagina, Direction.fromString(ordemOrdenacao), campoOrdenacao); 
			
			//Chamada do findAll com o objeto pageRequest que contém as ifnormações de paginação e ordenação
			return servicoRepo.findAll(specServico, pageRequest);
		}

	/*public List<ServicoDTO> getAll() {
		List<Servico> servicos = new ArrayList<>();
		servicos = servicoRepo.findAll();
		List<ServicoDTO> servicosDTO = servicos.stream().map(servico -> ServicoDTO.createServicoDTO(servico))
				.collect(Collectors.toList());
		return servicosDTO;
	}
	*/
	public List<ServicoDTO> findByTitulo(String titulo){
			
			List<Servico> servicoLista = servicoRepo.findByTitulo(titulo);		 
	        
			new ServicoDTO();
			List<ServicoDTO> servicosDTO = servicoLista.stream()
	        .map(servico -> ServicoDTO.createServicoDTO(servico))
	        .collect(Collectors.toList());
			
	        return servicosDTO;

	}
	
}
