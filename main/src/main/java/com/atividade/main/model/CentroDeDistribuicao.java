package com.atividade.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data

public class CentroDeDistribuicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long centroDedistribuicaoId;
	@Column(nullable = false)
	private String nome;
	@OneToMany
	@JoinColumn(name = "partileiraId")
	@Column(nullable = false)
	private List<Partileira> partileira;
	@OneToMany
	@JoinColumn(name = "endID")
	@Column(nullable = false)
	private Endereco endereco;
	@OneToMany
	@JoinColumn(name = "livroId")
	@Column(nullable = false)
	private List<Book> book;
	
	public CentroDeDistribuicao(long id, String nome, List<Partileira> partileira, Endereco endereco, List<Book> book) {
		super();
		this.centroDedistribuicaoId = id;
		this.nome = nome;
		this.partileira = partileira;
		this.endereco = endereco;
		this.book = book;
	}
	
	public CentroDeDistribuicao() {
		
	}

	public long getId() {
		return centroDedistribuicaoId;
	}

	public void setId(long id) {
		this.centroDedistribuicaoId = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Partileira> getPartileira() {
		return partileira;
	}

	public void setPartileira(List<Partileira> partileira) {
		this.partileira = partileira;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	
}
