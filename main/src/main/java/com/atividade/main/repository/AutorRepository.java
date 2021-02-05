package com.Atividade.main.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Atividade.main.model.Autor;



@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

//buscar por nome do autor   
	public Autor findAutorByNome(String nome);
	
//	retorna uma listapaginadar ordenada por nome
	public List<Autor>findAllByNome(String nome, Pageable pagina);
	
}
