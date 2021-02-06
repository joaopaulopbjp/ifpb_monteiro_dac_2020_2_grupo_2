package com.atividade.main.model;

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
	
	@Column(nullable = false)
	private String status;


	public int getPedidoID() {
		return pedidoID;
	}


	public void setPedidoID(int pedidoID) {
		this.pedidoID = pedidoID;
	}


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public Date getDataVenda() {
		return dataVenda;
	}


	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	

}
