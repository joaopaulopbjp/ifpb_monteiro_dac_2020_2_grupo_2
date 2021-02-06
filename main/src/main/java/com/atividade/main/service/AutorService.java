package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Autor;
import com.atividade.main.repository.AutorRepository;


@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	public Autor save(Autor autor) {
		return autorRepository.save(autor);
	}
	
	public void edit(Autor autor) {
		autorRepository.save(autor);
	}
	
	public void excluir(long id) {
		autorRepository.deleteById(id);
	}
	
	public Autor findById(long id) {
		Optional<Autor> autor =autorRepository.findById(id);
		return autor.get();
	}
	
	public Autor getAutorPorNome(String nome){
		return autorRepository.findAutorByNome(nome);
	}
	
	public Page<Autor> getListaOrdenadaAsedente(Pageable page){
        return autorRepository.findAll(page);
	}
	
}
