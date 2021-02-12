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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name ="LIVRO")
@Data
public class Book {
	
  	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long livroId;
  	
  	@Column(nullable = false)
	private String titulo;
  	
  	@Column(nullable = false)
	private String descricao;
  	
  	@Column(nullable = false)
  	private BigDecimal price;
  	
  	@Column(nullable = false)
  	private String ISBN;
  	
  	@Column(nullable = false)
  	private byte capa;
  	
  	@Column(nullable = false)
  	private String edicao;
  	
  	@Column(nullable = false)
  	private String anoPublicacao;
  	
  	@OneToOne
  	@JoinColumn(name = "categoriaId")
  	private Categoria categoria;
	
	@OneToMany(mappedBy = "bookId")
	private List<BookPedido>listaPedido;
	
	
	@ManyToMany(fetch= FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinTable(name="livro_Atores",
				joinColumns = @JoinColumn(name="livroId"),
				inverseJoinColumns = @JoinColumn(name="autorId"))
	private List<Autor> listAutor;
	
	
	
				

}
