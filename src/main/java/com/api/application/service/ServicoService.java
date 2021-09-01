package com.api.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.application.dto.ServicoDTO;
import com.api.application.exception.StandardException;
import com.api.application.model.Servico;
import com.api.application.repository.ServicoRepository;

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

	public List<ServicoDTO> getAll() {
		List<Servico> servicos = new ArrayList<>();
		servicos = servicoRepo.findAll();
		List<ServicoDTO> servicosDTO = servicos.stream().map(servico -> ServicoDTO.createServicoDTO(servico))
				.collect(Collectors.toList());
		return servicosDTO;
	}
	
}
