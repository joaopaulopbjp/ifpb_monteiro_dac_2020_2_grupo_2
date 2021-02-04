package com.atividade.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import com.atividade.main.model.Book;
import com.atividade.main.service.BookService;


@Controller
public class BookController{
	
	
	@Autowired
	private BookService bookService; 
	
	
	
	public void save(Book Book) {
		bookService.save(Book);
	}
	
	public void edit() {
		
	}
	
	public void excluir(long id) {
		bookService.excluir(id);
	}
	
	public Book getBookPorId(long id){
		return bookService.findById(id);
	}
	
	public Book getBookPorNome(String nome){
		return bookService.getBookPorNome(nome);
	}
	
	public Page<Book> getListaOrdenadaAsedentePrice(){
        return bookService.getListaOrdenadaAsedente(PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC, "price")));
	}
		

}
