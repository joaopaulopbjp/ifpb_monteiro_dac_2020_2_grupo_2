package com.atividade.main.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.main.event.RecursoCriadoEvent;
import com.atividade.main.model.Categoria;
import com.atividade.main.service.CategoriaService;

@RestController
@RequestMapping("/categoriacontroller")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService; 
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
//	metodo de salvar categoria
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaService.save(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCategoriaId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

//	metodo de atualizar entidade
	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> update(@PathVariable Long codigo, @RequestBody Categoria categoria){
		Categoria categoriaSalva = categoriaService.update(categoria);
		return ResponseEntity.ok(categoriaSalva);
	}

	//	metodo de deletar
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(long id) {
		categoriaService.excluir(id);
	}
		
	public Categoria findById(long id) {
		return categoriaService.CategoriafindById(id);
	}

	
}
