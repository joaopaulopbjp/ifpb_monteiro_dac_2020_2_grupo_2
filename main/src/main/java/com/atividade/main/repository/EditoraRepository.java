package com.atividade.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.main.model.Editora;



@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{ 

		
}
