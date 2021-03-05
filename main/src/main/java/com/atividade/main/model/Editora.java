package com.atividade.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String rua;

	@Column(nullable = false)
	private int numero;

	@Column(nullable = false)
	private String bairro;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false, length = 2)
	private String UF;

}
