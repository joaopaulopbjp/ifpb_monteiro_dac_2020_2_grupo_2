package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Estoque;
import com.atividade.main.service.EstoqueService;



@Service
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueService;

	public Estoque save(Estoque Estoque) {
		return estoqueService.save(Estoque);
	}
	
	public void edit(Estoque Estoque) {
		estoqueService.save(Estoque);
	}
	
	public void excluir(long id) {
		estoqueService.excluir(id);
	}
	
	public Estoque findById(long id) {
		return estoqueService.findById(id);
	}
	
	public Page<Estoque> getListaOrdenadaAsedente(Pageable page){
        return estoqueService.getListaOrdenadaAsedente(page);
	}
	
//	consultar os 5 livros mais baratos disponíveis no estoque;
	public Page<Estoque> getListaCincoMaisBaratos(Pageable page){
        return estoqueService.getListaCincoMaisBaratos(page);
	}
	
}
