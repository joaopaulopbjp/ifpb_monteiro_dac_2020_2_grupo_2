package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.main.model.Autor;
import com.atividade.main.service.AutorService;


@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;

	public void save(Autor autor) {
		autorService.save(autor);
	}

	public void edit(Autor autor) {
		autorService.edit(autor);
	}

	public void excluir(long id) {
		autorService.excluir(id);
	}

	public Autor findById(long id) {
		return autorService.findById(id);
	}

	public Autor getAutorPorNome(String nome) {
		return autorService.getAutorPorNome(nome);
	}

	public Page<Autor> getListaOrdenadaAsedente(Pageable page) {
		return autorService.getListaOrdenadaAsedente(page);
	}

}
