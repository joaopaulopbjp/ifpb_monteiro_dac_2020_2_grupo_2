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
import com.atividade.main.model.Autor_;
import com.atividade.main.model.Book;
import com.atividade.main.model.Book_;
import com.atividade.main.repository.filter.BookFilter;

public class BookRepositoryImpl  implements BookRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Book> filter(BookFilter filter, Pageable page) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
		Root<Book> root = criteria.from(Book.class);
		Predicate[] predicates = criarRestricoes(filter,builder, root );
		root.fetch(Autor_.AUTOR_ID);
		criteria.where(predicates);
		TypedQuery<Book> query = manager.createQuery(criteria);
		adicionarPaginacao(query,page);
		return new PageImpl<>(query.getResultList(), page,totalDeRegistro(filter));
	}
	

	private Long totalDeRegistro(BookFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Book> root = criteria.from(Book.class);
		Predicate[] predicates = criarRestricoes(filter,builder, root );
		criteria.where(predicates).multiselect(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


	private void adicionarPaginacao(TypedQuery<Book> query, Pageable page) {
		int paginaAtual =  page.getPageNumber();
		int totalRegistroPage = page.getPageSize();
		int primeiroResgistroPage = paginaAtual * totalRegistroPage;
		
		query.setFirstResult(primeiroResgistroPage);
		query.setMaxResults(totalRegistroPage);
		
	}


	private Predicate[] criarRestricoes(BookFilter filter, CriteriaBuilder builder, Root<Book> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();		
	
		if(filter.getTitulo()!=null) {
			predicates.add(builder.like(builder.lower(root.get(Book_.titulo)), "%"+filter.getTitulo().toLowerCase()+"%"));
		}if(filter.getCategoria()!=null) {
			predicates.add(builder.equal(root.get(Book_.categoria),filter.getCategoria()));
		}if(filter.getAnoPublicacao()!=null) {
			predicates.add(builder.equal(root.get(Book_.anoPublicacao),filter.getAnoPublicacao()));
		}if(filter.getPriceDe()!=0 && filter.getPriceAte()!=0) {
			predicates.add(builder.between(root.get(Book_.price), filter.getPriceDe(), filter.getPriceAte()));
		}if(filter.getEditora()!=null) {
			predicates.add(builder.equal(root.get(Book_.editora), filter.getEditora()));
		}
		
		return predicates.toArray( new Predicate[predicates.size()]);
	}

}
