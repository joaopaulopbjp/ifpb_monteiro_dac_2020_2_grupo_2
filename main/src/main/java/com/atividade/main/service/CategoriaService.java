package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Categoria;
import com.atividade.main.repository.CategoriaRepository;

import antlr.collections.List;



@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria save(Categoria Categoria) {
		return categoriaRepository.save(Categoria);
	}
	
	public Categoria update(Categoria Categoria) {
		return categoriaRepository.save(Categoria);
	}
	
	public void excluir(long id) {
		categoriaRepository.deleteById(id);
	}
		

	public Categoria CategoriafindById(long id) {
		Optional<Categoria> Categoria=categoriaRepository.findById(id);
		return Categoria.get();
	}

	
}
