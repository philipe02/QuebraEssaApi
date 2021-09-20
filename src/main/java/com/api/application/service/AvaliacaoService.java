package com.api.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.application.dto.AvaliacaoDTO;
import com.api.application.model.Avaliacao;
import com.api.application.repository.AvaliacaoRepository;
import com.api.application.repository.ClienteRepository;
import com.api.application.repository.FornecedorRepository;

@Service
public class AvaliacaoService {

	@Autowired
	AvaliacaoRepository avaliacaoRepo;
	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	FornecedorRepository fornecedorRepo;

	public String avaliarFornecedor(AvaliacaoDTO avaliacao) {
		Avaliacao avaliacaoFormatada = new Avaliacao(null, clienteRepo.getById(avaliacao.getIdCliente()),
				fornecedorRepo.getById(avaliacao.getIdFornecedor()), avaliacao.getPontuacao(),
				avaliacao.getComentario());
		avaliacaoRepo.save(avaliacaoFormatada);
		return "Avaliação enviada com sucesso!";
	}

	public List<Avaliacao> getAllAvaliacoes(Integer idCliente, Integer idFornecedor) {
		if (idCliente != null)
			return clienteRepo.getById(idCliente).getAvaliacoes();
		if (idFornecedor != null)
			return fornecedorRepo.getById(idFornecedor).getAvaliacoes();
		return avaliacaoRepo.findAll();
	}

}
