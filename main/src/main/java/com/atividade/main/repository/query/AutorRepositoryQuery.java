package com.atividade.main.repository.query;

import java.util.List;

import com.atividade.main.model.Autor;
import com.atividade.main.repository.filter.AutorFilter;

public interface AutorRepositoryQuery {
	
	public List<Autor> filter(AutorFilter autorFilter);

}
