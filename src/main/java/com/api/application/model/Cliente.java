package com.api.application.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="clientes")
public class Cliente {
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
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="grupo_confianca",
	joinColumns = @JoinColumn(name = "id_confiador"),
	inverseJoinColumns = @JoinColumn(name="id_confiado"))
	@JsonIgnore
	List<Cliente> grupoConfianca;
}
