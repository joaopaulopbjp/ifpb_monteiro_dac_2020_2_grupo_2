package com.Atividade.main.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
//esta


@Entity
@Data
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pedidoID;
	
	@OneToOne
	private Usuario user;
	
	@ManyToMany(fetch= FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinTable(name="pedidolivro",
				joinColumns = @JoinColumn(name="pedidoid"),
				inverseJoinColumns = @JoinColumn(name="livroid"))
	private List<Book> books;
	
	private BigDecimal total;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVenda;
	
	
	private String status;
	
	
	

}
