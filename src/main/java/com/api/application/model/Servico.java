package com.api.application.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Entity(name = "servicos")
public class Servico {

	@Id
	@Column
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	Integer id;

	@Column
	String titulo;

	@Column
	String descricao;

	@OneToMany(mappedBy = "servico", fetch = FetchType.EAGER)
	@JsonIgnore
	@Transient
	private List<Fornecedor> fornecedores;

}
