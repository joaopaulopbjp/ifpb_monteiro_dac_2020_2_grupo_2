package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atividade.main.model.Pagamento;
import com.atividade.main.service.PagamentoService;

@Controller
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService; 
	
	public void save(Pagamento Pagamento) {
		pagamentoService.save(Pagamento);
	}

	public void edit(Pagamento Pagamento) {
		pagamentoService.edit(Pagamento);
	}

	public void excluir(long id) {
		pagamentoService.excluir(id);
	}

	public Pagamento findById(long id) {
		return pagamentoService.PagamentofindById(id);
	}

	
}
