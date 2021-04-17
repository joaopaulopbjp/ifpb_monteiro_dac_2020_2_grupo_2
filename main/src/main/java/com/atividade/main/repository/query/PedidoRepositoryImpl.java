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

import com.atividade.main.model.Pedido;
import com.atividade.main.model.Pedido_;
import com.atividade.main.repository.filter.PedidoFilter;

import lombok.Data;

@Data
public class PedidoRepositoryImpl implements PedidoRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Pedido> filter(PedidoFilter pedidoFilter, Pageable page) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Pedido> criteria = builder.createQuery(Pedido.class);
		
		Root<Pedido> root = criteria.from(Pedido.class);
		
		Predicate[] predicates = criarRestricoes(pedidoFilter,builder, root );
		
		criteria.where(predicates);
		
		TypedQuery<Pedido> query = manager.createQuery(criteria);
		
		adicionarPaginacao(query,page);
		
		return new PageImpl<>(query.getResultList(), page,totalDeRegistro(pedidoFilter));
	}
	
	private Predicate[] criarRestricoes(PedidoFilter pedidoFilter, CriteriaBuilder builder, Root<Pedido> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();		
	
		if(pedidoFilter.getUser()!=null) {
			predicates.add(builder.equal(root.get(Pedido_.user),pedidoFilter.getUser())); 
			
		}
		
		return predicates.toArray( new Predicate[predicates.size()]);
	}
	
	
	private void adicionarPaginacao(TypedQuery<Pedido> query, Pageable page) {
		int paginaAtual =  page.getPageNumber();
		int totalRegistroPage = page.getPageSize();
		int primeiroResgistroPage = paginaAtual * totalRegistroPage;
		
		query.setFirstResult(primeiroResgistroPage);
		query.setMaxResults(totalRegistroPage);
		
	}
	
	private Long totalDeRegistro(PedidoFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Pedido> root = criteria.from(Pedido.class);
		Predicate[] predicates = criarRestricoes(filter,builder, root );
		criteria.where(predicates).multiselect(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
	
	
}
