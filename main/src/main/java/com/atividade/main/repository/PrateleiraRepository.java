package com.atividade.main.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.main.model.Prateleira;

public interface PrateleiraRepository extends JpaRepository<Prateleira, Long>{
	
//		buscar por nome da prateleira   
		public Prateleira findPrateleiraByIndetificacao(String indentificacao);
		
//		retorna uma listapaginadar ordenada por nome
		public List<Prateleira>findAllByIndetificacao(String nome, Pageable pagina);

}
