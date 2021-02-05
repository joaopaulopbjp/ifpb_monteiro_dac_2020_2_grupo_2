package com.Atividade.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name ="LIVRO")
public class Book {
	
  	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long livroId;
  	
  	@Column(nullable = false)
	private String titulo;
  	
  	@Column(nullable = false)
	private String descricao;
  	
  	private float price;
	
	
	@ManyToMany(fetch= FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinTable(name="livro_Atores",
				joinColumns = @JoinColumn(name="livroId"),
				inverseJoinColumns = @JoinColumn(name="autorId"))
	private List<Autor> listAutor;
	
	

	public long getLivroId() {
		return livroId;
	}

	public void setLivroId(long livroId) {
		this.livroId = livroId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descrição) {
		this.descricao = descrição;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Autor> getListAutor() {
		return listAutor;
	}

	public void setListAutor(List<Autor> listAutor) {
		this.listAutor = listAutor;
	}
	
	
				

}
