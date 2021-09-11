package com.api.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.application.dto.ClienteDTO;
import com.api.application.dto.FornecedorDTO;
import com.api.application.model.Cliente;
import com.api.application.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> getAllClientes(@RequestParam(required = false, defaultValue = "5") Integer itensPagina,
			@RequestParam(required = false, defaultValue = "0") Integer numeroPagina,
			@RequestParam(required = false, defaultValue = "ASC") String direcaoOrdenacao,
			@RequestParam(required = false, defaultValue = "nome") String campoOrdem){
		Page<ClienteDTO> listaRetorno = clienteService.findAll(itensPagina,numeroPagina, direcaoOrdenacao, campoOrdem);
		return new ResponseEntity<Page<ClienteDTO>>(listaRetorno, HttpStatus.OK);
	}
	
	@GetMapping("/confianca/{id}")
	public ResponseEntity<List<Cliente>> getGrupoConfianca (@PathVariable("id") Integer id){
		return ResponseEntity.ok(clienteService.getGrupoConfianca(id));
	}
	
	@PostMapping("/confianca")
	public ResponseEntity<String> adicionarAGrupoConfiança(@RequestBody HashMap<String, Integer> relacao){
		return ResponseEntity.ok(clienteService.adicionarConfianca(relacao));
		
	}
}
