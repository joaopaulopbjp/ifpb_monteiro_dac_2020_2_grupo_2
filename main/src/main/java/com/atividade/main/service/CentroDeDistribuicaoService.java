package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.main.model.CentroDeDistribuicao;
import com.atividade.main.model.Pagamento;
import com.atividade.main.repository.CentroDeDistribuicaoRepository;



@Service
public class CentroDeDistribuicaoService {
	
	@Autowired
	private CentroDeDistribuicaoRepository centroDeDistribuicaoRepository;

	public CentroDeDistribuicao save(CentroDeDistribuicao Pagamento) {
		return centroDeDistribuicaoRepository.save(Pagamento);
	}
	
	public void edit(CentroDeDistribuicao Pagamento) {
		centroDeDistribuicaoRepository.save(Pagamento);
	}
	
	public void excluir(long id) {
		centroDeDistribuicaoRepository.deleteById(id);
	}
	
	public CentroDeDistribuicao getCentrofindById(long id) {
		Optional<CentroDeDistribuicao> Pagamento=centroDeDistribuicaoRepository.findById(id);
		return Pagamento.get();
	}

	
}
