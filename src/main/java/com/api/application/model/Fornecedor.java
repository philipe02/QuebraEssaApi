package com.api.application.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "fornecedor")
public class Fornecedor {

	@Id
	@Column
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;
	@Column
	private String cpf;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String telefone;
	@Column
	@JsonIgnore
	private String descricao;
	@Column
	private String endereco;
	@Column
	@JsonIgnore
	@Transient
	private String complemento;
	@Column
	@JsonIgnore
	@Transient
	private String bairro;
	@Column
	@JsonIgnore
	@Transient
	private String cidade;
	@Column
	@JsonIgnore
	@Transient
	private String estado;
	@Column
	private Double pontuacao;
	@Column
	private Integer qtdVotos;
	@Column
	private String latitude;
	@Column
	private String longitude;
	@ManyToMany(mappedBy = "indicados")
	@JsonIgnore
	private List<Cliente> indicadores;
	@ManyToOne
	@JoinColumn(name = "servicoid")
	private Servico servico;

}
