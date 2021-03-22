package com.atividade.main.controller;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atividade.main.model.Autor;
import com.atividade.main.service.AutorService;


@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Autor> save(@RequestBody Autor autor, HttpServletResponse response) {
		Autor autorSave = autorService.save(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(autor.getAutorId()).toUri();
				response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(autorSave);		
	}
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
	public void edit(@RequestBody Autor autor) {
		autorService.edit(autor);
	}
    
    @PostMapping("/del")
	public void excluir(long id) {
		autorService.excluir(id);
	}

	 @GetMapping("/{codigo}")
	public ResponseEntity<Autor> findById(@PathVariable long id) {
		 Autor autor = autorService.findById(id);
		return autor!=null ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
	}
	 @GetMapping("/autornome")  
	public Autor getAutorPorNome(String nome) {
		return autorService.getAutorPorNome(nome);
	}
	 @GetMapping("/lista")
	public Page<Autor> getListaOrdenadaAsedente(Pageable page) {
		return autorService.getListaOrdenadaAsedente(page);
	}

}
