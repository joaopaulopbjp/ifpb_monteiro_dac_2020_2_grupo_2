package com.atividade.main.controller;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.main.event.RecursoCriadoEvent;
import com.atividade.main.model.Editora;
import com.atividade.main.service.EditoraService;

@RestController
@RequestMapping("/Editora")
public class EditoraController {
	
	@Autowired
	private EditoraService editoraService;

	@Autowired
	private ApplicationEventPublisher publisher;

//	metodo de salvar autor
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Editora> save(@Valid @RequestBody Editora editora, HttpServletResponse response) {
		Editora editoraSalvo = editoraService.save(editora);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, editoraSalvo.getEditoraId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(editoraSalvo);
	}

//	metodo de atualizar entidade
	@PutMapping("/{codigo}")
	public ResponseEntity<Editora> update(@PathVariable Long codigo, @RequestBody Editora editora) {
		Editora EditoraSalvo = editoraService.update(codigo, editora);
		return ResponseEntity.ok(EditoraSalvo);
	}

//	metodo de deletar
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(long id) {
		editoraService.excluir(id);
	}
	
	public Editora EditorafindById(long id) {
		Editora editora=editoraService.findById(id);
		return editora;
	}
	
	public Editora getEditoraPorNome(String nome) {
		return editoraService.getEditoraPorNome(nome);
	}	
	public Page<Editora> getListaOrdenadaAsedente(Pageable page){
		return editoraService.getListaOrdenadaAsedente(page);
	}	

}
