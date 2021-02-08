package com.atividade.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoriaId;
	
	@Column(nullable = false)
	private String descricao;
	
	
	
	public Categoria(long categoriaId, String descricao) {
		super();
		this.categoriaId = categoriaId;
		this.descricao = descricao;
	}
	
	public Categoria() {
		
	}
	
	public long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(long categoriaId) {
		this.categoriaId = categoriaId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
