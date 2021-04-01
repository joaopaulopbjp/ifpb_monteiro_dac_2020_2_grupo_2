package com.atividade.main.repository.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.atividade.main.model.Autor;
import com.atividade.main.model.Autor_;
import com.atividade.main.repository.filter.AutorFilter;

public class AutorRepositoryImpl  implements AutorRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Autor> filter(AutorFilter autorFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Autor> criteria = builder.createQuery(Autor.class);
		Root<Autor> root = criteria.from(Autor.class);
		Predicate[] predicates = criarRestricoes(autorFilter,builder, root );
		
		
		TypedQuery<Autor> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	

	private Predicate[] criarRestricoes(AutorFilter autorFilter, CriteriaBuilder builder, Root<Autor> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();		
	
		if(autorFilter.getNome()!=null) {
			predicates.add(builder.like(builder.lower(root.get(Autor_.nome)), "%"+autorFilter.getNome().toLowerCase()+"%"));
		}
		
		return null;
	}

}
