package com.atividade.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Entity
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String celular;
	
	@Column(nullable = false)
	private String CPF;
	
	@Column(nullable = false)
	private String sexo;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private String papel;
	
	@OneToMany
	@JoinColumn(name="endID")
	private List<Endereco> enderecos;
	
	@PrePersist
	private void inclusao() {
		Email email = new Email();
		email.sendEmail(this.email, "Oi, "+this.nome+" Bem vindo a CJL Livraria online!"
				, "Seu dados de acesso são:\n"
						+ "Email:"+this.email+"\n"
								+ "Senha:"+this.senha);
	}
	@PreUpdate
	private void atulizacao() {
		Email email = new Email();
		String end = null;
		for(Endereco e: this.enderecos) {
			end = "Cep:"+e.getCep()+"\n"
				 +"Rua:"+e.getRua()+"\n"
				 +"Numero:"+e.getNumero()+"\n"
				 +"Rua:"+e.getComplemento()+"\n"
				 +"Bairro:"+e.getBairro()+"\n"
				 +"Cidade:"+e.getCidade()+"\n"
				 +"UF:"+e.getUF()+"\n"
				 +"PontoReferencia:"+e.getPontoReferencia()+"\n"
				 +"==========*==========";
		}
		email.sendEmail(this.email, "Oi, "+this.nome+" Seu dados foram Atualizados!"
				, "Seu atualizado foram:\n"
						+ "CPF:"+this.CPF+"\n"
						+ "Nome:"+this.nome+"\n"
						+ "Celular:"+this.celular+"\n"
						+ "Sexo:"+this.email+"\n"
						+ "Email:"+this.email+"\n"
						+ "Senha:"+this.senha+"\n"
						+ "============*Seus endereços*===========\n"
						+ end);
	}
	
	
}
