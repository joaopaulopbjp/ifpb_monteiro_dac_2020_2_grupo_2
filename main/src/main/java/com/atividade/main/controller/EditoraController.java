package com.atividade.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atividade.main.model.Editora;
import com.atividade.main.repository.EditoraRepository;

@Service
public class EditoraController {
	
	@Autowired
	private EditoraRepository editoraService;

	public Editora save(Editora editora) {
		return editoraService.save(editora);
	}
	
	public void edit(Editora editora) {
		editoraService.save(editora);
	}
	
	public void excluir(long id) {
		editoraService.deleteById(id);
	}
	
	public Editora EditorafindById(long id) {
		Optional<Editora> editora=editoraService.findById(id);
		return editora.get();
	}
	
	public Editora getEditoraPorNome(String nome) {
		return editoraService.findEditoraByNome(nome);
	}	
	public Page<Editora> getListaOrdenadaAsedente(Pageable page){
		return editoraService.findAll(page);
	}	

}
