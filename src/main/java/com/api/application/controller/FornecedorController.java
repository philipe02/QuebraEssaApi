package com.api.application.controller;

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

import com.api.application.dto.FornecedorDTO;
import com.api.application.model.Fornecedor;
import com.api.application.service.FornecedorService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/fornecedores")
public class FornecedorController {

	@Autowired
	FornecedorService fornecedorService;

	@GetMapping
	public ResponseEntity<Page<FornecedorDTO>> findAll(@RequestParam(required = false) String servico,
			@RequestParam(required = false) String nome, @RequestParam(required = false) Double nota,
			@RequestParam(required = false) String search,
			@RequestParam(required = false, defaultValue = "10") Integer itensPagina,
			@RequestParam(required = false, defaultValue = "0") Integer numeroPagina,
			@RequestParam(required = false, defaultValue = "ASC") String direcaoOrdenacao,
			@RequestParam(required = false, defaultValue = "nome") String campoOrdem) {

		Page<FornecedorDTO> listaRetorno = fornecedorService.findAll(servico, nome, nota, search, itensPagina,
				numeroPagina, direcaoOrdenacao, campoOrdem);
		return new ResponseEntity<Page<FornecedorDTO>>(listaRetorno, HttpStatus.OK);
	}

	// método post para adicionar fornecedores no banco
	@PostMapping
	public ResponseEntity<Fornecedor> adicionarNovoFornecedor(@RequestBody Fornecedor fornecedor) {
		return ResponseEntity.created(null).body(fornecedorService.save(fornecedor));
	}

	// endpoint para mostrar detalhes do fornecedor
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> getDetailsOfFornc(@PathVariable("id") Integer id) {
		Fornecedor fornecedorSalvo = fornecedorService.detalharFornecedor(id);

		return new ResponseEntity<Fornecedor>(fornecedorSalvo, HttpStatus.OK);
	}
}
