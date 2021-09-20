package com.api.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.application.model.Indicacao;
import com.api.application.repository.ClienteRepository;
import com.api.application.repository.IndicacaoRepository;

@Service
public class IndicacaoService {

	@Autowired
	IndicacaoRepository indicacaoRepo;
	@Autowired
	ClienteRepository clienteRepo;

	public String indicarFornecedor(Indicacao relacao) {

		return "Indicado com sucesso";
	}

//	public List<Fornecedor> getIndicadosPorConfianca(Integer idUsuario) {
//		List<Cliente> grupoConfianca = this.getGrupoConfianca(idUsuario);
//		List<Fornecedor> indicadosPorGrupo = new ArrayList<>();
//
//		grupoConfianca.stream().forEach(cliente -> indicadosPorGrupo.addAll(cliente.getIndicados()));
//
//		Set<Fornecedor> set = new HashSet<>(indicadosPorGrupo);
//		indicadosPorGrupo.clear();
//		indicadosPorGrupo.addAll(set);
//
//		Collections.shuffle(indicadosPorGrupo);
//
//		try {
//			return indicadosPorGrupo.subList(0, 4);
//		} catch (Exception e) {
//			return indicadosPorGrupo;
//		}
//
//	}
}
