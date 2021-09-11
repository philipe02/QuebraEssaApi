package com.api.application.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.application.model.Cliente;
import com.api.application.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepo;
	
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
	
}
