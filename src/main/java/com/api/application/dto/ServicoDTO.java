package com.api.application.dto;

import com.api.application.model.Servico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {

	private String titulo;
	private String descricao;

	public static ServicoDTO createServicoDTO(Servico servico) {
		ServicoDTO servicoDTO = new ServicoDTO(servico.getTitulo(), servico.getDescricao());

		return servicoDTO;
	}
}
