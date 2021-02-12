package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.atividade.main.model.BookPedido;
import com.atividade.main.service.BookPedidoService;



@Service
public class BookPedidoController {
	
	@Autowired
	private BookPedidoService bookPedidoService;

	public void save(BookPedido bookPedido) {
		bookPedidoService.save(bookPedido);
	}
	
	public void edit(BookPedido BookPedido) {
		bookPedidoService.edit(BookPedido);
	}
	
	public void excluir(long id) {
		bookPedidoService.excluir(id);
	}
	
	public BookPedido findById(long id) {
		return bookPedidoService.findById(id);
	}
	
	public Page<BookPedido> getListaOrdenadaAsedente(Pageable page){
        return bookPedidoService.getListaOrdenadaAsedente(page);
	}
	
//	consultar os 5 livros mais baratos disponíveis no BookPedido;
	public Page<BookPedido> getListaCincoMaisBaratos(Pageable page){
        return bookPedidoService.getListaOrdenadaAsedente(page);
	}
	
}
