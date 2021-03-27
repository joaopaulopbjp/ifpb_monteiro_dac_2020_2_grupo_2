package com.atividade.main.model;

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
@Table(name = "LIVRO")
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LIVROID")
	private long livroId;

	@Column(nullable = false)
	private String titulo;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private double price;

	// @Column(nullable = false)
	private String ISBN;

	// @Lob
	// @Column(nullable = false)
//  	no futuro atualizar para array
	private byte capa;

	// @Column(nullable = false)
	private String edicao;

	@Column(name="ANOPUBLICACAO")
	private String anoPublicacao;

	@OneToOne
	@JoinColumn(name = "CATEGORIA")
	private Categoria categoria;

	@OneToOne
	@JoinColumn(name = "EDITORAID")
	private Editora editora;

	@OneToOne(mappedBy = "book")
	private Estoque estoque;

	@OneToMany(mappedBy = "bookId")
	private List<BookPedido> listaPedido;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "LIVROAUTOR", joinColumns = @JoinColumn(name = "LIVROID"), inverseJoinColumns = @JoinColumn(name = "AUTORID"))
	private List<Autor> listAutor;

}
