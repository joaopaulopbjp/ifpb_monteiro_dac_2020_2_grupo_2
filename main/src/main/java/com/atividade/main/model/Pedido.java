package com.atividade.main.model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Column(nullable = false)
	private BigDecimal total;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

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
	
	@OneToMany(mappedBy = "pedidoId")
	private List<BookPedido>listaPedido;
	
	

	
	@PrePersist
	private void setDataDeCriacaoPedido() {
		this.dataCriacao = new Date();
		this.status = "pedente";
	}

	@PreUpdate
	private void setBaixaNoEstoque() {
		if (this.dataFechamento != null) {
			EstoqueService estoqueService = new EstoqueService();
			this.status = "finalizado";
			for (int i=0;i<this.listaPedido.size();i++) {
				Estoque estoque = estoqueService.findEstoqueByBook(this.listaPedido.get(i).getBookId());	
				estoque.setQuantidade(estoque.getQuantidade() - this.listaPedido.get(i).getQuantidadeVendida());
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
