package com.api.application.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.application.model.Fornecedor;
import com.api.application.service.FornecedorService;

@RestController
@RequestMapping("/api/v1")
public class FornecedorControllerV1 {

	@Autowired
	FornecedorService serviceApi;
	
	@GetMapping("/buscarTodos")
	public ResponseEntity<ArrayList<Fornecedor>> findAll(
			@RequestParam Integer id){
		
		ArrayList<Fornecedor> listaRetorno = (ArrayList<Fornecedor>) serviceApi.findAll(id);
		return new ResponseEntity<ArrayList<Fornecedor>>(listaRetorno,HttpStatus.OK);
	}
	
	//método post para adicionar fornecedores no banco
	@PostMapping
	public ResponseEntity<Object> adicionarNovoFornecedor(
			@RequestBody Fornecedor fornecedor
			){
		return ResponseEntity.created(null).body(serviceApi.save(fornecedor));
	}
	
}
