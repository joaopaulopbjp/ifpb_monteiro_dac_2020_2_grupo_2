package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Endereco;
import com.atividade.main.repository.EnderecoRepository;


@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
		
	}
	
	public void edit(Endereco endereco) {
		enderecoRepository.save(endereco);
	}
	
	public void excluir(long id) {
		enderecoRepository.deleteById(id);
	}
	
	public Endereco findById(long id) {
		Optional<Endereco> endereco =enderecoRepository.findById(id);
		return endereco.get();
	}
	
	public Endereco getEnderecoPorNome(String CEP, String rua, String cidade){
		return enderecoRepository.findEnderecoByCepRuaCidade(CEP, rua, cidade);
	}
	
	public Page<Endereco> getListaOrdenadaAsedente(Pageable page){
        return enderecoRepository.findAll(page);
	}


}
