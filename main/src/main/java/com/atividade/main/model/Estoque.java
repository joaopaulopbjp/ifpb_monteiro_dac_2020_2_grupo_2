package com.atividade.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Estoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long estoqueid;
	
	@OneToOne
	@JoinColumn(name="livroid")
	private Book book;
	
	private int quantidade;
	
	@Column(length = 1)
	private String prateleira;
	

}
