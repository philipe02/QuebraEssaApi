package com.api.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.application.dto.AvaliacaoDTO;
import com.api.application.model.Avaliacao;
import com.api.application.service.AvaliacaoService;

@RestController
@RequestMapping("/v1/avaliacao")
public class AvaliacaoController {

	@Autowired
	AvaliacaoService avaliacaoService;

	@GetMapping
	public ResponseEntity<List<Avaliacao>> getAllAvaliacoes(@RequestParam(required = false) Integer cliente,
			@RequestParam(required = false) Integer fornecedor) {
		return ResponseEntity.ok(avaliacaoService.getAllAvaliacoes(cliente, fornecedor));
	}

	@PostMapping
	ResponseEntity<String> avaliarFornecedor(@RequestBody AvaliacaoDTO avaliacao) {
		return ResponseEntity.created(null).body(avaliacaoService.avaliarFornecedor(avaliacao));
	}
}
