package com.atividade.main.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import com.atividade.main.model.Pagamento;
import com.atividade.main.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService; 
	
	@Autowired
	private ApplicationEventPublisher publisher;

//	metodo de salvar Pagamento
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pagamento> save(@Valid @RequestBody Pagamento pagamento, HttpServletResponse response) {
		Pagamento pagamentoSalvo = pagamentoService.save(pagamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pagamentoSalvo.getPagamentoId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoSalvo);
	}

//	metodo de atualizar entidade
	@PutMapping("/{codigo}")
	public ResponseEntity<Pagamento> update(@PathVariable Long codigo, @RequestBody Pagamento pagamento) {
		Pagamento pagamentoSalvo = pagamentoService.update(codigo, pagamento);
		return ResponseEntity.ok(pagamentoSalvo);
	}

//	metodo de deletar
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(long id) {
		pagamentoService.delete(id);
	}
	

	public Pagamento findById(long id) {
		return pagamentoService.PagamentofindById(id);
	}

	
}
