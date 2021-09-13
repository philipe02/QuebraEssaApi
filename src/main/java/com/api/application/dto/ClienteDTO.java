package com.api.application.dto;

import java.util.List;

import com.api.application.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	private Integer id;
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private List<Cliente> grupoConfianca;

	public static ClienteDTO createClienteDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getId(), cliente.getCpf(), cliente.getNome(), cliente.getEmail(),
				cliente.getTelefone(), cliente.getEndereco(), cliente.getBairro(), cliente.getCidade(),
				cliente.getEstado(), cliente.getGrupoConfianca());
		return clienteDTO;
	}
}
