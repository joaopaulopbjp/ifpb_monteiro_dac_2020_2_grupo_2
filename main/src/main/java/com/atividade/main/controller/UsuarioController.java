package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.atividade.main.model.Usuario;
import com.atividade.main.service.UsuarioService;

@Controller
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
	
}
