package com.atividade.main.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.main.event.RecursoCriadoEvent;
import com.atividade.main.model.Book;
import com.atividade.main.service.BookService;


@RestController
@RequestMapping("/book")
public class BookController{
	
	
	@Autowired
	private BookService bookService; 
	
	@Autowired
	private ApplicationEventPublisher publisher;

	
//	metodo de salvar book
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Book> save(@Valid @RequestBody Book book, HttpServletResponse response) {
		Book bookSalvo = bookService.save(book);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, bookSalvo.getLivroId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(bookSalvo);
	}

//	metodo de atualizar entidade
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Book> update(@PathVariable Long codigo, @RequestBody Book book) {
		Book bookSalvo = bookService.update(codigo, book);
		return ResponseEntity.ok(bookSalvo);
	}

//	metodo de deletar
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(long id) {
		bookService.delete(id);
	}
	
	
//	public void save(Book Book) {
//		bookService.save(Book);
//	}
//	
//	public void edit() {
//		
//	}
//	
//	public void excluir(long id) {
//		bookService.excluir(id);
//	}
//	
//	public Book getBookPorId(long id){
//		return bookService.findById(id);
//	}
//	
//	public Book getBookPorNome(String nome){
//		return bookService.getBookPorNome(nome);
//	}
	
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
	public Page<Book> getListaBookAllPaginada(Pageable page){
        return bookService.getListaBookAllPaginada(page);
	}
		

}
