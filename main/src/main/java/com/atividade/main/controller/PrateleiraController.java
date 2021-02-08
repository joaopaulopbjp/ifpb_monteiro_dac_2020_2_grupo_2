package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.main.model.Prateleira;
import com.atividade.main.service.PrateleiraService;

@RestController
@RequestMapping("/Prateleira")
public class PrateleiraController {
	
	@Autowired
	private PrateleiraService prateleiraService;
	
	public void save(Prateleira prateleira) {
		prateleiraService.save(prateleira);
	}

	public void edit(Prateleira prateleira) {
		prateleiraService.edit(prateleira);
	}

	public void excluir(long id) {
		prateleiraService.excluir(id);
	}

	public Prateleira findById(long id) {
		return prateleiraService.findById(id);
	}

	public Page<Prateleira> getListaOrdenadaAsedente(Pageable page) {
		return prateleiraService.getListaOrdenadaAsedente(page);
	}


}
