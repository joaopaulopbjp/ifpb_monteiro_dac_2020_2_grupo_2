package com.atividade.main.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pagamentoID;
	
	@Column(nullable = false)	
	private String descricao;
	
	
	

	public Pagamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Pagamento(long pagamentoID, String descricao) {
		super();
		this.pagamentoID = pagamentoID;
		this.descricao = descricao;
	}



	public long getPagamentoID() {
		return pagamentoID;
	}

	public void setPagamentoID(long pagamentoID) {
		this.pagamentoID = pagamentoID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
