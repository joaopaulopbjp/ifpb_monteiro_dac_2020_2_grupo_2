package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.main.model.Book;
import com.atividade.main.service.BookService;


@RestController
@RequestMapping("/book")
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
	
	public Page<Book> getListaCincoMaisBaratos(){
        return bookService.getListaOrdenadaAsedente(PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "price")));
	}
	
//	consultar todos os livros (em estoque e sem estoque tb) ordenados de forma ascendente pelo título de forma paginada 
	//(defina um tamanho fixo para a página - ex.: 5 livros). O usuário pode informar a página que deseja consultar.

	public Page<Book> getAllBookList(){
        return bookService.getListaOrdenadaAsedente(PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "titulo")));
	}
	
	//	retorna uma lista de livro
	public Page<Book> getAllBookList(Pageable page){
        return bookService.getListaOrdenadaAsedente(page);
	}
		

}
