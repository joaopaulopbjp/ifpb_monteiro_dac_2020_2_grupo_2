package com.atividade.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
//classe intermediaria entre pedido e livro fazendo uym reação de n to n  
public class BookPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookPedidoId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVenda;
	
	@Column(nullable = false)	
	private int quantidadeVendida;
	
	@ManyToOne
	@JoinColumn(name="livroId")
	private Book bookId;
	
	@ManyToOne
	@JoinColumn(name="pedidoID")
	private Pedido pedidoId;
	
}
