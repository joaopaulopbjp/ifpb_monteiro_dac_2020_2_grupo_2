package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atividade.main.model.Categoria;
import com.atividade.main.service.CategoriaService;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService; 
	
	public void save(Categoria Categoria) {
		categoriaService.save(Categoria);
	}

	public void edit(Categoria Categoria) {
		categoriaService.edit(Categoria);
	}

	public void excluir(long id) {
		categoriaService.excluir(id);
	}

	public Categoria findById(long id) {
		return categoriaService.CategoriafindById(id);
	}

	
}
