package com.atividade.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long endID;
	
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
	
	@Column(nullable = false)
	private String complemento;
	
	@Column(nullable = false, name ="PONTOREFERENCIA")
	private String pontoReferencia;
	
	
	
	
	
}
