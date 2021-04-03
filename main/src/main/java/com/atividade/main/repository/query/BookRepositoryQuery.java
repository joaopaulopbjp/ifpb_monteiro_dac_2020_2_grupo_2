package com.atividade.main.repository.query;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atividade.main.model.Book;
import com.atividade.main.repository.filter.BookFilter;

public interface BookRepositoryQuery {
	
	public Page<Book> filter(BookFilter bookFilter, Pageable page);
	
	public List<Book> filterCincoBaratos();
	
	public Page<Book> findListBookOrdenadaTituloComOuSemEstoque(Pageable page);

}
