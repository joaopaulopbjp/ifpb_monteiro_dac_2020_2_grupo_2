package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Usuario;
import com.atividade.main.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}
	
	public void edit(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void excluir(long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario findById(long id) {
		Optional<Usuario> usuario =usuarioRepository.findById(id);
		return usuario.get();
	}
	
	public Usuario getUsuarioPorNome(String nome){
		return usuarioRepository.findUsuarioByNome(nome);
	}
	
	public Page<Usuario> getListaOrdenadaAsedente(Pageable page){
        return usuarioRepository.findAll(page);
	}
	
	
}
