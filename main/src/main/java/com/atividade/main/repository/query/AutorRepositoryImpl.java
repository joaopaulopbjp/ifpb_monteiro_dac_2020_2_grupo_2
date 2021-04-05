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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.atividade.Autor_;
import com.atividade.main.model.Autor;
import com.atividade.main.repository.filter.AutorFilter;

public class AutorRepositoryImpl  implements AutorRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Autor> filter(AutorFilter autorFilter, Pageable page) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Autor> criteria = builder.createQuery(Autor.class);
		Root<Autor> root = criteria.from(Autor.class);
		Predicate[] predicates = criarRestricoes(autorFilter,builder, root );
		criteria.where(predicates);
		TypedQuery<Autor> query = manager.createQuery(criteria);
		adicionarPaginacao(query,page);
		return new PageImpl<>(query.getResultList(), page,totalDeRegistro(autorFilter));
	}
	

	private Long totalDeRegistro(AutorFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Autor> root = criteria.from(Autor.class);
		Predicate[] predicates = criarRestricoes(filter,builder, root );
		criteria.where(predicates).multiselect(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


	private void adicionarPaginacao(TypedQuery<Autor> query, Pageable page) {
		int paginaAtual =  page.getPageNumber();
		int totalRegistroPage = page.getPageSize();
		int primeiroResgistroPage = paginaAtual * totalRegistroPage;
		
		query.setFirstResult(primeiroResgistroPage);
		query.setMaxResults(totalRegistroPage);
		
	}


	private Predicate[] criarRestricoes(AutorFilter autorFilter, CriteriaBuilder builder, Root<Autor> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();		
	
		if(autorFilter.getNome()!=null) {
			predicates.add(builder.like(builder.lower(root.get(Autor_.nome)), "%"+autorFilter.getNome().toLowerCase()+"%"));
		}
		
		return predicates.toArray( new Predicate[predicates.size()]);
	}

}
