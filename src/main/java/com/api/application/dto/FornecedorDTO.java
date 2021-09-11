package com.api.application.dto;

import com.api.application.model.Fornecedor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO {
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private String descricao;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String servico;
	private Double pontuacao;
	private Double nota;
	private Integer qtdVotos;

	public static FornecedorDTO createFornecedorDTO(Fornecedor fornecedor) {
		FornecedorDTO fornecedorDTO = new FornecedorDTO(fornecedor.getCpf(), fornecedor.getNome(),
				fornecedor.getEmail(), fornecedor.getTelefone(), fornecedor.getDescricao(), fornecedor.getEndereco(),
				fornecedor.getBairro(), fornecedor.getCidade(), fornecedor.getEstado(),
				fornecedor.getServico().getTitulo(),fornecedor.getPontuacao(), fornecedor.getPontuacao()/fornecedor.getQtdVotos(), fornecedor.getQtdVotos());

		return fornecedorDTO;
	}
}
