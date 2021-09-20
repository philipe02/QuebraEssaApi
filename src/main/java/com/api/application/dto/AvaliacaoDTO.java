package com.api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {

	private Integer idCliente;
	private Integer idFornecedor;
	private Double pontuacao;
	private String comentario;
}
