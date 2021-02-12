package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.atividade.main.model.BookPedido;
import com.atividade.main.repository.BookPedidoRepository;

@Service
public class BookPedidoService {
	
	@Autowired
	private BookPedidoRepository bookPedidoRepository;
	

	public void save(BookPedido bookPedido) {
		bookPedidoRepository.save(bookPedido);
	}
	
	public void edit(BookPedido bookPedido) {
		bookPedidoRepository.save(bookPedido);
	}
	
	public void excluir(long id) {
		bookPedidoRepository.deleteById(id);
	}
	
	public BookPedido findById(long id) {
		Optional<BookPedido> endereco =bookPedidoRepository.findById(id);
		return endereco.get();
	}
	
	
	public Page<BookPedido> getListaOrdenadaAsedente(Pageable page){
        return bookPedidoRepository.findAll(page);
	}

	
	

}
