package com.api.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.api.application.dto.ServicoDTO;
import com.api.application.model.Servico;
import com.api.application.service.ServicoService;

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
	public ResponseEntity<List<ServicoDTO>> buscarTodosServicos() {
		return ResponseEntity.ok(servicoService.getAll());
	}
	
	@GetMapping("/titulo")
	public ResponseEntity<List<ServicoDTO>> buscarPorTitulo(@RequestParam String titulo) {
		return ResponseEntity.ok(servicoService.findByTitulo(titulo));
	}
}
