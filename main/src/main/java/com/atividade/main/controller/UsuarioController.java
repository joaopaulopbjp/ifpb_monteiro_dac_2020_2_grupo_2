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
import com.atividade.main.model.Usuario;
import com.atividade.main.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 
	
	@Autowired
	private ApplicationEventPublisher publisher;

//	metodo de salvar Usuario
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = usuarioService.save(usuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getUserID()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

//	metodo de atualizar entidade
	@PutMapping("/{codigo}")
	public ResponseEntity<Usuario> update(@PathVariable Long codigo, @RequestBody Usuario usuario) {
		Usuario usuarioSalvo = usuarioService.update(codigo, usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}

//	metodo de deletar
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(long id) {
		usuarioService.delete(id);
	}


	public Usuario findById(long id) {
		return usuarioService.findById(id);
	}

	public Usuario getUsuarioPorNome(String nome) {
		return usuarioService.getUsuarioPorNome(nome);
	}

	public Page<Usuario> getListaOrdenadaAsedente(Pageable page) {
		return usuarioService.getListaOrdenadaAsedente(page);
	}
	
	public Usuario getUsuarioPorEmail(String email) {
		return usuarioService.getUserPorEmail(email);
	}
	
}
