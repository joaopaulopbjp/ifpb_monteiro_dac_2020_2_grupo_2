package com.atividade.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Editora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long editoraId;
	
	@Column(nullable = false)
	private String CNPJ;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToOne
	private Endereco endereco;
	
}
