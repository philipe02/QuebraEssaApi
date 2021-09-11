package com.api.application.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.application.dto.ClienteDTO;
import com.api.application.dto.FornecedorDTO;
import com.api.application.model.Cliente;
import com.api.application.model.Fornecedor;
import com.api.application.repository.ClienteRepository;
import com.api.application.specification.FornecedorSpecification;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepo;
	
	public Page<ClienteDTO> findAll(Integer itensPagina,
			Integer numeroPagina, String direcaoOrdenacao, String campoOrdem) {
		PageRequest pageRequest = PageRequest.of(numeroPagina, itensPagina, Sort.Direction.valueOf(direcaoOrdenacao),
				campoOrdem);
		
		Page<Cliente> pageCliente = (Page<Cliente>) clienteRepo.findAll(pageRequest);
		
		List<ClienteDTO> clientesDTO = pageCliente.stream()
				.map(cliente -> ClienteDTO.createClienteDTO(cliente)).collect(Collectors.toList());
		
		int totalElements = clientesDTO.size();

		return new PageImpl<ClienteDTO>(clientesDTO, pageRequest, totalElements);
	}
	
	public List<Cliente> getGrupoConfianca(Integer idUsuario){
		Cliente cliente = clienteRepo.findById(idUsuario).get();
		//ordenando o grupo de confiança pelo nome
		List<Cliente> grupoConfianca = cliente.getGrupoConfianca();
		Collections.sort(grupoConfianca, new Comparator<Cliente>() {
			  public int compare(Cliente c1, Cliente c2) {
			    if (c1.getNome().equals(c2.getNome())) return 0;
			    return c1.getNome().compareTo(c2.getNome());
			  }});
		
		return grupoConfianca;
	}
	public String adicionarConfianca(HashMap<String, Integer> relacao) {
		clienteRepo.addToConfianca(relacao.get("confiador"), relacao.get("confiado"));
		return "Adicionado com sucesso";
	}
	
}
