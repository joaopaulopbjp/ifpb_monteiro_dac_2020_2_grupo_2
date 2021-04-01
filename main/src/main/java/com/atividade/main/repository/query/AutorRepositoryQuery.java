package com.atividade.main.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atividade.main.model.Autor;
import com.atividade.main.repository.filter.AutorFilter;

public interface AutorRepositoryQuery {
	
	public Page<Autor> filter(AutorFilter autorFilter, Pageable page);

}
