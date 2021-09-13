package com.api.application.specification;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.api.application.model.Fornecedor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FornecedorSpecification implements Specification<Fornecedor> {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String servico;
	private String search;

	@Override
	public Predicate toPredicate(Root<Fornecedor> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		ArrayList<Predicate> predicates = new ArrayList<Predicate>();

		if (nome != null) {

			Predicate p = criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
			predicates.add(p);
		}
		if (servico != null) {

			Predicate p = criteriaBuilder.equal(root.join("servico").get("titulo"), servico);
			predicates.add(p);
		}
		if (search != null) {
			Predicate nome = criteriaBuilder.like(root.get("nome"), "%" + search + "%");
			Predicate servico = criteriaBuilder.like(root.join("servico").get("titulo"), "%" + search + "%");
			predicates.add(nome);
			predicates.add(servico);
		}
		// Transforma um arrayList em um array
		Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);

		// Caso search exista o predicado de ser OR
		if (search != null) {
			Predicate pOr = criteriaBuilder.or(arrayPredicates);
			return pOr;
		}
		// Cria uma restrição AND entre todos os predicados do array
		Predicate pAnd = criteriaBuilder.and(arrayPredicates);

		return pAnd;
	}
}
