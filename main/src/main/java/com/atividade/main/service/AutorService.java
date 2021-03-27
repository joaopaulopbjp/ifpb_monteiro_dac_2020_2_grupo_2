package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	
	public  Autor update(Long codigo, Autor autor) {
		Autor autorSalvo = autorRepository.findById(codigo).get();
		if(autorSalvo==null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(autor, autorSalvo,"autorId");
		autorRepository.save(autor);
		return autorSalvo;	
	}
	
	
	public void delete(long id) {
		autorRepository.deleteById(id);
	}
	
	public Autor findById(long id) {
		Optional<Autor> autorSalvo = autorRepository.findById(id);
	
		
		return autorSalvo != null ? autorSalvo.get() : null;
	}
	
	public Autor getAutorPorNome(String nome){
		return autorRepository.findAutorByNome(nome);
	}
	
	public Page<Autor> getListaOrdenadaAsedente(Pageable page){
        return autorRepository.findAll(page);
	}
	
}
