package com.atividade.main.service;

import java.util.List;
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
import com.atividade.main.service.exception.BookExistException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public Book save(Book book) {
		if(isBookExist(book.getISBN())) {
			throw new BookExistException();
		}
		return bookRepository.save(book);
	}
	
	public Book update(Long codigo, Book book) {
		Book bookSalvo = findById(codigo);
		if (bookSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(book, bookSalvo, "livroId");
		bookRepository.save(bookSalvo);
		return bookSalvo;
	}
	
	public void delete(long id) {
		bookRepository.deleteById(id);
	}
	
	public boolean isBookExist(String ISBN) {
		if(findBookByISBN(ISBN)!=null) {
			return true;
		}
		return false;
	}
	public Book findBookByISBN(String ISBN) {
		Book bookSalvo = bookRepository.findBookByISBN(ISBN);
		return bookSalvo!=null? bookSalvo:null;
	}
	
	public Book findById(long id) {
		Optional<Book> b = bookRepository.findById(id);
		return b.get();
	}
	
	public Book getBookPorNome(String nome){
		return bookRepository.findBookByTitulo(nome);
	}
	
	public Page<Book> findListBookOrdenadaTituloComOuSemEstoque(Pageable page){
        return bookRepository.findListBookOrdenadaTituloComOuSemEstoque(page);
	}
	
//	consultar os 5 livros mais baratos disponíveis no estoque;
	public List<Book> findListaCincoMaisBaratos(){
        return bookRepository.filterCincoBaratos();
	}
	public Page<Book> getListaBookAllPaginada(BookFilter filter ,Pageable page){
        return bookRepository.filter(filter , page);
	}
}
