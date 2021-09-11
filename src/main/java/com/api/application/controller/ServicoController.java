package com.api.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.application.dto.ServicoDTO;
import com.api.application.model.Servico;
import com.api.application.service.ServicoService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/servico")
public class ServicoController {

	@Autowired
	ServicoService servicoService;

	@PostMapping
	public ResponseEntity<Object> adicionarServico(@RequestBody Servico servico) throws Exception {
		return ResponseEntity.created(null).body(servicoService.save(servico));
	}

	@GetMapping
	public ResponseEntity<Page<Servico>> buscarTodosServicos(
			@RequestParam(required = false, defaultValue = "0") Integer numeroPagina,
			@RequestParam(required = false, defaultValue = "3") Integer itensPorPagina,
			@RequestParam(required = false, defaultValue = "id") String campoOrdenacao,
			@RequestParam(required = false, defaultValue = "ASC") String direcaoOrdenacao,
			@RequestParam(required=false) Integer id,
			@RequestParam(required=false) String titulo){
		
			Page<Servico> servicos = servicoService.buscarTodos
					(numeroPagina,
					itensPorPagina, 
					campoOrdenacao,
					direcaoOrdenacao, 
					id, titulo);
		
			return new ResponseEntity<Page<Servico>>(servicos, HttpStatus.OK);
	}

	@GetMapping("/titulo")
	public ResponseEntity<List<ServicoDTO>> buscarPorTitulo(@RequestParam String titulo) {
		return ResponseEntity.ok(servicoService.findByTitulo(titulo));
	}
}
