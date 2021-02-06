package com.atividade.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.main.model.CentroDeDistribuicao;
import com.atividade.main.service.CentroDeDistribuicaoService;

@Service
public class CentroDeDistribuicaoController{
	
	@Autowired
	private CentroDeDistribuicaoService centroDeDistribuicaoService;

	public CentroDeDistribuicao save(CentroDeDistribuicao centro) {
		return centroDeDistribuicaoService.save(centro);
	}
	
	public void edit(CentroDeDistribuicao centro) {
		centroDeDistribuicaoService.save(centro);
	}
	
	public void excluir(long id) {
		centroDeDistribuicaoService.excluir(id);
	}
	
	public CentroDeDistribuicao getCentroLista(long id) {
	
		return centroDeDistribuicaoService.getCentrofindById(id);
	}

	
}
