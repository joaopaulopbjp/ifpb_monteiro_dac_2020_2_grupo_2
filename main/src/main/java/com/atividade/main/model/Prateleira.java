package com.atividade.main.model;

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
	
	private CentroDistribuicao centrodis;

	public long getPraID() {
		return prateleiraID;
	}

	public void setPraID(long praID) {
		this.prateleiraID = praID;
	}

	public CentroDistribuicao getCentrodis() {
		return centrodis;
	}

	public void setCentrodis(CentroDistribuicao centrodis) {
		this.centrodis = centrodis;
	}
	
}
