package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Prateleira;
import com.atividade.main.repository.PrateleiraRepository;

@Service
public class PrateleiraService {
	
	@Autowired
	private PrateleiraRepository prateleiraRepository;
	
	public Prateleira save(Prateleira prateleira) {
		return prateleiraRepository.save(prateleira);
	}
	
	public void edit(Prateleira prateleira) {
		prateleiraRepository.save(prateleira);
	}
	
	public void excluir(long id) {
		prateleiraRepository.deleteById(id);
	}
	
	public Prateleira findById(long id) {
		Optional<Prateleira> prateleira =prateleiraRepository.findById(id);
		return prateleira.get();
	}
	
	public Prateleira getPrateleiraPorNome(String nome){
		return prateleiraRepository.findPrateleiraByNome(nome);
	}
	
	public Page<Prateleira> getListaOrdenadaAsedente(Pageable page){
        return prateleiraRepository.findAll(page);
	}


}
