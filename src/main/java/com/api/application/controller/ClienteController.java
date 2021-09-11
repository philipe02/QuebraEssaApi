package com.api.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.application.model.Cliente;
import com.api.application.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/confianca/{id}")
	public List<Cliente> getGrupoConfianca (@PathVariable("id") Integer id){
		return clienteService.getGrupoConfianca(id);
	}
}
