package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Pedido;
import com.atividade.main.repository.PedidoRepository;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public void edit(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void excluir(long id) {
		pedidoRepository.deleteById(id);
	}
	
	public Pedido findById(long id) {
		Optional<Pedido> pedido =pedidoRepository.findById(id);
		return pedido.get();
	}
	
	public Pedido getPedidoPorNome(String nome){
		return pedidoRepository.findPedidoByName(nome);
	}
	
	public Page<Pedido> getListaOrdenadaAsedente(Pageable page){
        return pedidoRepository.findAll(page);
	}
	

}
