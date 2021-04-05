package com.atividade.main.repository.dto;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.atividade.Autor_;
import com.atividade.main.model.Autor;
import com.atividade.main.model.Book;
import com.atividade.main.model.Sexo;

import lombok.Data;

@Data
public class AutorDTO {

	private Long autorId;

	private String nome;

	private Sexo sexo;

	private String nacionalidade;

	private Date dtNascimento;

	private List<Book> listLivro;
	
    public AutorDTO (Autor autor) {
    	BeanUtils.copyProperties(autor, this, Autor_.LIST_LIVRO);
    }

}
