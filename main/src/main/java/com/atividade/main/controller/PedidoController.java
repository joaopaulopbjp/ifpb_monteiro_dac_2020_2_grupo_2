package com.atividade.main.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.main.event.RecursoCriadoEvent;
import com.atividade.main.model.Pedido;
import com.atividade.main.service.PedidoService;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
//	metodo de salvar autor
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pedido> save(@Valid @RequestBody Pedido pedido, HttpServletResponse response) {
		Pedido pedidoSalva = pedidoService.save(pedido);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pedidoSalva.getPedidoID()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalva);
	}
	
//	metodo de atualizar entidade
	@PutMapping("/{codigo}")
	public ResponseEntity<Pedido> update(@PathVariable Long codigo, @RequestBody Pedido pedido ) {
		Pedido pedidoSalva = pedidoService.update(codigo, pedido);
		return ResponseEntity.ok(pedidoSalva);
	}
//	metodo de deletar
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(long id) {
		pedidoService.excluir(id);
	}

	public Pedido findById(long id) {
		return pedidoService.findById(id);
	}
	
	@GetMapping("/lista")
	public Page<Pedido> getListaOrdenadaAsedente(Pageable page) {
		return pedidoService.getListaOrdenadaAsedente(page);
	}

}
