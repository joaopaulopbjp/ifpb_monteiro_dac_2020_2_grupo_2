package com.atividade.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.main.model.Endereco;
import com.atividade.main.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService; 
	
	public void save(Endereco endereco) {
		enderecoService.save(endereco);
	}

	public void edit(Endereco endereco) {
		enderecoService.edit(endereco);
	}

	public void excluir(long id) {
		enderecoService.excluir(id);
	}

	public Endereco findById(long id) {
		return enderecoService.findById(id);
	}

//	public Endereco getEnderecoPorCepRuaCidade(cep, rua, cidade) {
//		return enderecoService.getEnderecoPorNome(cep, rua, cidade);
//	}
}
