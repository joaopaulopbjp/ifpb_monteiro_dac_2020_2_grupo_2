package com.atividade.main.model;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.validation.constraints.NotNull;

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
	private double total;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

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
	}

	@PreUpdate
	private void setBaixaNoEstoque() {
		if (this.dataFechamento != null) {
			EstoqueService estoqueService = new EstoqueService();
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
