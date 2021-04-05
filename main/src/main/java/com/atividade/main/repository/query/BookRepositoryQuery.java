package com.atividade.main.repository.query;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atividade.main.model.Book;
import com.atividade.main.repository.dto.BookResumo;
import com.atividade.main.repository.filter.BookFilter;

public interface BookRepositoryQuery {
	
	public Page<Book> filter(BookFilter bookFilter, Pageable page);
	
	public List<BookResumo> filterCincoBaratos();
	
	public Page<BookResumo> findListBookOrdenadaTituloComOuSemEstoque(Pageable page);

}
