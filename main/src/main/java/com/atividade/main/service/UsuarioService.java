package com.atividade.main.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Usuario;
import com.atividade.main.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private EntityManager em = null;
	private Root<Usuario> root = null;
	private CriteriaBuilder build = null;
	private CriteriaQuery<Usuario> query;
	
	private void setCriteria() {
		build = em.getCriteriaBuilder();
		query = build.createQuery(Usuario.class);
		root = query.from(Usuario.class);
	}
	

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
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}

	public Usuario getUsuarioPorNome(String nome) {
		return usuarioRepository.findUsuarioByNome(nome);
	}

	public Page<Usuario> getListaOrdenadaAsedente(Pageable page) {
		return usuarioRepository.findAll(page);
	}

	public Usuario getUserPorEmail(String email) {

		return usuarioRepository.findUsuarioByEmail(email);
	}

	// enviar uma notificação para finalização do pedido*
	public void sendEmailNotficacao(long id) {
		setCriteria();
		query.where(build.equal(root.get("userID"),id));
		Usuario user = em.createQuery(query).getSingleResult();
		
	}

}
