package com.api.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.application.model.Servico;
import com.api.application.repository.ServicoRepository;
import com.api.application.service.ServicoService;

@SpringBootTest
class ServicoTests {

	@Autowired
	ServicoService servicoService;

	@MockBean
	ServicoRepository servicoRepo;

	@BeforeEach
	void setup() {
		Servico servico1 = new Servico(1, "Programador", null, null);
		Servico servico2 = new Servico(null, "Programador", null, null);
		when(servicoRepo.save(servico2)).thenReturn(servico1);
	}

	@Test
	void save() throws Exception {
		Servico servico = new Servico(null, "Programador", null, null);
		Servico servicoSalvo = servicoService.save(servico);
		assertEquals(servicoSalvo.getId(), 1);
	}

}
