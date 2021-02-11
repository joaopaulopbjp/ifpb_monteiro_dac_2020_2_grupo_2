package com.atividade.main.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Book;
import com.atividade.main.model.Estoque;
import com.atividade.main.model.Usuario;
import com.atividade.main.repository.EstoqueRepository;



@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	private EntityManager em = null;
	private Root<Estoque> root = null;
	private CriteriaBuilder build = null;
	private CriteriaQuery<Estoque> query = null;
	
	
	private void setCriteria() {
		build = em.getCriteriaBuilder();
		query = build.createQuery(Estoque.class);
		root = query.from(Estoque.class);
	}
	


	public Estoque save(Estoque Estoque) {
		return estoqueRepository.save(Estoque);
	}
	
	public void edit(Estoque Estoque) {
		estoqueRepository.save(Estoque);
	}
	
	public void excluir(long id) {
		estoqueRepository.deleteById(id);
	}
	
	public Estoque findById(long id) {
		Optional<Estoque> b =estoqueRepository.findById(id);
		return b.get();
	}
	
	public Page<Estoque> getListaOrdenadaAsedente(Pageable page){
        return estoqueRepository.findAll(page);
	}
	
//	consultar os 5 livros mais baratos disponíveis no estoque;
	public Page<Estoque> getListaCincoMaisBaratos(Pageable page){
        return estoqueRepository.findAll(page);
	}
	
	public Estoque findEstoqueByBook(Book book) {
		return estoqueRepository.findEstoqueByBook(book);
	}
	
}
