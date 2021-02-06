package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atividade.main.model.Pagamento;
import com.atividade.main.repository.PagamentoRepository;



@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public Pagamento save(Pagamento Pagamento) {
		return pagamentoRepository.save(Pagamento);
	}
	
	public void edit(Pagamento Pagamento) {
		pagamentoRepository.save(Pagamento);
	}
	
	public void excluir(long id) {
		pagamentoRepository.deleteById(id);
	}
	
	public Pagamento PagamentofindById(long id) {
		Optional<Pagamento> Pagamento=pagamentoRepository.findById(id);
		return Pagamento.get();
	}

	
}
