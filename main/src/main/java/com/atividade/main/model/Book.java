package com.atividade.main.model;

import java.math.BigDecimal;
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
import javax.persistence.OneToOne;
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
  	
  	private BigDecimal price;
  	
  	@OneToOne
  	@JoinColumn(name = "categoriaId")
  	private Categoria categoria;
	
	
	@ManyToMany(fetch= FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinTable(name="livro_Atores",
				joinColumns = @JoinColumn(name="livroId"),
				inverseJoinColumns = @JoinColumn(name="autorId"))
	private List<Autor> listAutor;
	
	private String ISPB;
	
	private Byte capa;
	
	private String edicao;

	private String ano;
	
	public String getISPB() {
		return ISPB;
	}

	public void setISPB(String iSPB) {
		ISPB = iSPB;
	}

	public Byte getCapa() {
		return capa;
	}

	public void setCapa(Byte capa) {
		this.capa = capa;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

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


	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Autor> getListAutor() {
		return listAutor;
	}

	public void setListAutor(List<Autor> listAutor) {
		this.listAutor = listAutor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
				

}
