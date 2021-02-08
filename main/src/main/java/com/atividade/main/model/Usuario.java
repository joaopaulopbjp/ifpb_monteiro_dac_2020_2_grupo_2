package com.atividade.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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

	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Usuario(long userID, String nome, String email, String celular, String cPF, String sexo, String senha,
			String papel) {
		super();
		this.userID = userID;
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		CPF = cPF;
		this.sexo = sexo;
		this.senha = senha;
		this.papel = papel;
	}



	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}
	
	
	
	
	
	
}
