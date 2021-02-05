package com.atividade.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.main.model.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Long>{ 

	
	//buscar por nome do titulo do book   
		public Book findBookByTitulo(String titulo);
		
		
}
