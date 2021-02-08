package com.atividade.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data

public class CentroDeDistribuicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long centroDedistribuicaoId;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToMany
	@JoinColumn(name = "prateleiraID")
	private List<Prateleira> partileira;
	
	@OneToOne
	@JoinColumn(name = "endID", nullable = false)
	private Endereco endereco;
	
	@OneToMany
	@JoinColumn(name = "livroId")
	private List<Book> estoque;
	
	
	

	public CentroDeDistribuicao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CentroDeDistribuicao(long centroDedistribuicaoId, String nome, List<Prateleira> partileira,
			Endereco endereco, List<Book> estoque) {
		super();
		this.centroDedistribuicaoId = centroDedistribuicaoId;
		this.nome = nome;
		this.partileira = partileira;
		this.endereco = endereco;
		this.estoque = estoque;
	}



	public long getCentroDedistribuicaoId() {
		return centroDedistribuicaoId;
	}

	public void setCentroDedistribuicaoId(long centroDedistribuicaoId) {
		this.centroDedistribuicaoId = centroDedistribuicaoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Prateleira> getPartileira() {
		return partileira;
	}

	public void setPartileira(List<Prateleira> partileira) {
		this.partileira = partileira;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Book> getEstoque() {
		return estoque;
	}

	public void setEstoque(List<Book> estoque) {
		this.estoque = estoque;
	}
	
	
	
	
}
