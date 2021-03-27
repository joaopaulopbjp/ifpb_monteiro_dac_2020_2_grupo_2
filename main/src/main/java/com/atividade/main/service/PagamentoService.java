package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	
	
	public Pagamento update(Long codigo ,Pagamento pagamento) {
		Pagamento pagamentoSalvo = pagamentoRepository.findById(codigo).get();
		if (pagamentoSalvo==null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(pagamento, pagamentoSalvo,"pagamentoId");
		pagamentoRepository.save(pagamento);
		return pagamentoSalvo;
	}
	
	public void delete(long id) {
		pagamentoRepository.deleteById(id);
	}
	
	public Pagamento PagamentofindById(long id) {
		Optional<Pagamento> Pagamento=pagamentoRepository.findById(id);
		return Pagamento.get();
	}

	
}
