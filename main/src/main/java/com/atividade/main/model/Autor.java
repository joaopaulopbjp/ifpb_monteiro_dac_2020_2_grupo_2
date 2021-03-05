package com.atividade.main.model;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;



@Entity
@Data
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="autorid")
	private long autorId;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(length = 1, nullable = false)
	private String sexo;
	
	@Column(nullable = false)
	private String nacionalidade;
	
	@Column(name="DATANASCIMENTO",nullable = false)
	private Date dtNascimento;
	
	@ManyToMany(mappedBy = "listAutor")
	private List<Book>listLivro;

	

}