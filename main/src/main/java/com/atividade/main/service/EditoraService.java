package com.atividade.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atividade.main.model.Editora;
import com.atividade.main.repository.EditoraRepository;



@Service
public class EditoraService {
	
	@Autowired
	private EditoraRepository editoraRepository;

	public Editora save(Editora editora) {
		return editoraRepository.save(editora);
	}
	
	public void edit(Editora editora) {
		editoraRepository.save(editora);
	}
	
	public void excluir(long id) {
		editoraRepository.deleteById(id);
	}
	
	public Editora EditorafindById(long id) {
		Optional<Editora> editora=editoraRepository.findById(id);
		return editora.get();
	}

	
}
