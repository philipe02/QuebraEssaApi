package com.api.application.specification;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.api.application.model.Servico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ServicoSpecification implements Specification<Servico> {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String titulo;

	@Override
	public Predicate toPredicate(Root<Servico> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		ArrayList<Predicate> predicates = new ArrayList<Predicate>();
		
		if(id != null) {
			
			Predicate p = criteriaBuilder.equal(root.get("id"), id);
			predicates.add(p);
		}
		if(titulo != null) {
			
			Predicate p = criteriaBuilder.equal(root.get("titulo"), titulo);
			predicates.add(p);
		}
		//Transforma um arrayList em um array
		Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
		
		//Cria uma restrição AND entre todos os predicados do array
		Predicate pAnd = criteriaBuilder.and(arrayPredicates);
		
		return pAnd;
	}
}
