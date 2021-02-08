package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.main.model.Pedido;
import com.atividade.main.service.PedidoService;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	public void save(Pedido pedido) {
		pedidoService.save(pedido);
	}

	public void edit(Pedido pedido ) {
		pedidoService.edit(pedido);
	}

	public void excluir(long id) {
		pedidoService.excluir(id);
	}

	public Pedido findById(long id) {
		return pedidoService.findById(id);
	}

	public Page<Pedido> getListaOrdenadaAsedente(Pageable page) {
		return pedidoService.getListaOrdenadaAsedente(page);
	}

}
