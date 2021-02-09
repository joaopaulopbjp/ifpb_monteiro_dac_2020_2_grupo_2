package com.atividade.main.model;

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
//e


@Entity
@Data
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pedidoID;
	
	@OneToOne
	@JoinColumn(name="userID")
	private Usuario user;
	
	@ManyToMany(fetch= FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinTable(name="pedidolivro",
				joinColumns = @JoinColumn(name="pedidoID"),
				inverseJoinColumns = @JoinColumn(name="livroId"))
	private List<Book> books;
	
	@Column(nullable = false)
	private BigDecimal total;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVenda;
	
	@Column(nullable = false)
//	private String status;
	
	private String status = "Pedente";
	
	@OneToOne
	@JoinColumn(name = "endID")
	private Endereco enderecoEntrega;

	@OneToOne
	@JoinColumn(name = "pagamentoId")
	private Pagamento pagamento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFechamento;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(int pedidoID, Usuario user, List<Book> books, BigDecimal total, Date dataVenda, String status,
			Endereco enderecoEntrega, Pagamento pagamento) {
		super();
		this.pedidoID = pedidoID;
		this.user = user;
		this.books = books;
		this.total = total;
		this.dataVenda = dataVenda;
		this.status = status;
		this.enderecoEntrega = enderecoEntrega;
		this.pagamento = pagamento;
	}

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

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	

}
