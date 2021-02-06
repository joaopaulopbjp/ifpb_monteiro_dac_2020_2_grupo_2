package com.atividade.main.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Editora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long editoraId;
	@Column(nullable = false)
	private String CNPJ;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Endereco endereco;
	public long getEditoraId() {
		return editoraId;
	}
	public void setEditoraId(long editoraId) {
		this.editoraId = editoraId;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	} 
	
	
	
}
