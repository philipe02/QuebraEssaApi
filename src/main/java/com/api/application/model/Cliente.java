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
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clientes")
public class Cliente {
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
	@OneToMany(mappedBy = "cliente")
	@JsonIgnoreProperties("cliente")
	private List<Avaliacao> avaliacoes;
	@OneToMany(mappedBy = "cliente")
	@JsonIgnoreProperties("cliente")
	private List<Indicacao> indicados;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "grupo_confianca", joinColumns = @JoinColumn(name = "id_confiador"), inverseJoinColumns = @JoinColumn(name = "id_confiado"))
	@JsonIgnore
	private List<Cliente> grupoConfianca;
}
