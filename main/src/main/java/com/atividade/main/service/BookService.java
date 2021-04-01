package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Book;
import com.atividade.main.repository.BookRepository;
import com.atividade.main.repository.filter.BookFilter;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public Book save(Book Book) {
		return bookRepository.save(Book);
	}
	
	public Book update(Long codigo, Book book) {
		Book bookSalvo = bookRepository.findById(codigo).get();
		if (bookSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(book, bookSalvo, "bookID");
		bookRepository.save(book);
		return bookSalvo;
	}
	
	public void delete(long id) {
		bookRepository.deleteById(id);
	}
	
	public Book findById(long id) {
		Optional<Book> b =bookRepository.findById(id);
		return b.get();
	}
	
	public Book getBookPorNome(String nome){
		return bookRepository.findBookByTitulo(nome);
	}
	
	public Page<Book> getListaOrdenadaAsedente(Pageable page){
        return bookRepository.findAll(page);
	}
	
//	consultar os 5 livros mais baratos disponíveis no estoque;
	public Page<Book> getListaCincoMaisBaratos(Pageable page){
        return bookRepository.findAll(page);
	}
	public Page<Book> getListaBookAllPaginada(BookFilter filter ,Pageable page){
        return bookRepository.filter(filter , page);
	}
}
