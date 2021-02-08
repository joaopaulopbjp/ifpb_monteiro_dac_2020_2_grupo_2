package com.atividade.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pagamentoId;
	
	@Column(nullable = false)	
	private String descricao;
	
	
	

	public Pagamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Pagamento(long pagamentoID, String descricao) {
		super();
		this.pagamentoId = pagamentoID;
		this.descricao = descricao;
	}



	public long getPagamentoID() {
		return pagamentoId;
	}

	public void setPagamentoID(long pagamentoID) {
		this.pagamentoId = pagamentoID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
