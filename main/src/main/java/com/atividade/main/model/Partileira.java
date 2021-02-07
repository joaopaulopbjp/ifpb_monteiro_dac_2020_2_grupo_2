package com.atividade.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Partileira {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patileiraId;
	@Column(nullable = false)
	private String identificacaoPartileira;
	
	public Partileira(long patileiraId, String identificacaoPartileira) {
		super();
		this.patileiraId = patileiraId;
		this.identificacaoPartileira = identificacaoPartileira;
	}
	
	public Partileira() {
		
	}

	public long getPatileiraId() {
		return patileiraId;
	}

	public void setPatileiraId(long patileiraId) {
		this.patileiraId = patileiraId;
	}

	public String getIdentificacaoPartileira() {
		return identificacaoPartileira;
	}

	public void setIdentificacaoPartileira(String identificacaoPartileira) {
		this.identificacaoPartileira = identificacaoPartileira;
	}
	
}
