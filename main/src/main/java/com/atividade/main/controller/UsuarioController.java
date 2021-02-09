package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.main.model.Usuario;
import com.atividade.main.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 
	
	public void save(Usuario usuario) {
		usuarioService.save(usuario);
	}

	public void edit(Usuario usuario) {
		usuarioService.edit(usuario);
	}

	public void excluir(long id) {
		usuarioService.excluir(id);
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
