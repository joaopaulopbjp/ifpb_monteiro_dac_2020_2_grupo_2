package com.Atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Atividade.main.model.Book;
import com.Atividade.main.repository.BookRepository;



@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public Book save(Book Book) {
		return bookRepository.save(Book);
	}
	
	public void edit(Book Book) {
		bookRepository.save(Book);
	}
	
	public void excluir(long id) {
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
	
}
