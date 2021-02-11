package com.atividade.main.model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import com.atividade.main.service.EstoqueService;

import lombok.Data;
//e

@Entity
@Data
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pedidoID;

	@OneToOne
	@JoinColumn(name = "userID")
	private Usuario user;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "pedidolivro", joinColumns = @JoinColumn(name = "pedidoID"), inverseJoinColumns = @JoinColumn(name = "livroId"))
	private List<Book> books;

	@Column(nullable = false)
	private BigDecimal total;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVenda;

	@Column(nullable = false)
	private String status;

	@OneToOne
	@JoinColumn(name = "endID")
	private Endereco enderecoEntrega;

	@OneToOne
	@JoinColumn(name = "pagamentoId")
	private Pagamento pagamento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFechamento;
	
	

	
	@PrePersist
	private void setDataDeCriacaoPedido() {
		this.dataVenda = new Date();
		this.status = "pedente";
	}

	@PreUpdate
	private void setBaixaNoEstoque() {
		if (this.dataFechamento != null) {
			EstoqueService estoqueService = new EstoqueService();
			this.status = "finalizado";
			for (Book b : getBooks()) {
				Estoque estoque = estoqueService.findEstoqueByBook(b);	
				estoque.setQuantidade(estoque.getQuantidade() - b.getQuantVenda());
				estoqueService.save(estoque);
			}
			Email email = new Email();
			try {
				email.sendEmailComAnexo(this.user.getEmail(),"Seu Pedido de numero: "+this.pedidoID+" foi finalizado!"
						, "Segue em anexo a nota fiscal\n Obrigado por comprar com agente!!!\n"
								+ "Att. CJL Livraria", null);
			} catch (MessagingException | IOException e) {
				e.printStackTrace();
			}
		}

	}

}
