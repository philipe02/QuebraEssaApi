package com.api.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.application.service.ServicoService;

@SpringBootTest
class ServicoTests {

	@MockBean
	ServicoService servicoService;

	@BeforeEach
	void setup() {
		/*
		 * ServicoDTO servico1 = new ServicoDTO("Programador", null); ServicoDTO
		 * servico2 = new ServicoDTO("Designer", null); List<ServicoDTO> listaServico =
		 * new ArrayList<>(); listaServico.add(servico1); listaServico.add(servico2);
		 * when(servicoService.getAll()).thenReturn(listaServico);
		 */
	}

	@Test
	void getAll() {
		/*
		 * ArrayList<ServicoDTO> listaServicos = (ArrayList<ServicoDTO>)
		 * servicoService.getAll(); assertEquals(listaServicos.get(0).getTitulo(),
		 * "Programador");
		 */
	}

}
