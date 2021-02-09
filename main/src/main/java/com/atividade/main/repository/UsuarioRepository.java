package com.atividade.main.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.main.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	

	
	

//	Buscar por nome do Usuario
	public Usuario findUsuarioByNome(String nome);
	
//	retorna uma listapaginadar ordenada por nome
	public List<Usuario>findAllByNome(String nome, Pageable pagina);
	
//	Buscar por nome do Usuario
	public Usuario findUsuarioByCPF(String CPF);
	
//	Buscar por email
	public Usuario findUsuarioByEmail(String email);
	
	

}
