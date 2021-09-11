package com.api.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	Integer id;
	@Column
	String cpf;
	@Column
	String nome;
	@Column
	String email;
	@Column
	String telefone;
	@Column
	@JsonIgnore
	String descricao;
	@Column
	String endereco;
	@Column
	@JsonIgnore
	@Transient
	String complemento;
	@Column
	@JsonIgnore
	@Transient
	String bairro;
	@Column
	@JsonIgnore
	@Transient
	String cidade;
	@Column
	@JsonIgnore
	@Transient
	String estado;
	@Column
	Double pontuacao;
	@Column
	Integer qtdVotos;
	@ManyToOne
	@JoinColumn(name = "servicoid")
	Servico servico;

}
