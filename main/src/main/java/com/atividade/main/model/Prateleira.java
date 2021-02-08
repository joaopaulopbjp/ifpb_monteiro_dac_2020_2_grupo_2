package com.atividade.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Prateleira {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prateleiraID;
	
	@Column(nullable = false)
	private String indetificacao;
	

	public long getPraID() {
		return prateleiraID;
	}

	public void setPraID(long praID) {
		this.prateleiraID = praID;
	}

	public long getPrateleiraID() {
		return prateleiraID;
	}

	public void setPrateleiraID(long prateleiraID) {
		this.prateleiraID = prateleiraID;
	}

	public String getIndetificacao() {
		return indetificacao;
	}

	public void setIndetificacao(String indetificacao) {
		this.indetificacao = indetificacao;
	}

	
	
}
