package com.atividade.main.repository.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.atividade.main.model.Autor;
import com.atividade.main.model.Book;
import com.atividade.main.model.Book_;
import com.atividade.main.model.Categoria;
import com.atividade.main.model.Categoria_;
import com.atividade.main.model.Editora;
import com.atividade.main.model.Estoque;
import com.atividade.main.model.Estoque_;

import lombok.Data;

@Data
public class BookDTO {
	
	private long livroId;
	private String titulo;
	private String descricao;
	private double price;
	private String ISBN;
	private String capa;
	private String edicao;
	private String anoPublicacao;
	private Categoria categoria;
	private Editora editora;
	private Estoque estoque;
	private List<AutorDTO> autores = new ArrayList<AutorDTO>();
	
	
	
    public BookDTO (Book book) {
    	BeanUtils.copyProperties(book,this, Book_.LISTA_PEDIDO,Book_.LIST_AUTOR);
    	this.autores = book.getListAutor().stream().map(e-> new AutorDTO(e)).collect(Collectors.toList());
    }

	public BookDTO() {
	}
	
	public Book convertBookDTOForBook(BookDTO dto) {
		Book book=null;
		BeanUtils.copyProperties(dto, book);
		
		return book;
	}


}
