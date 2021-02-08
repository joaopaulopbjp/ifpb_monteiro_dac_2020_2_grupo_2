package com.atividade.main.model;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long autorId;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(length = 1, nullable = false)
	private String sexo;
	
	@Column(nullable = false)
	private String nacionalidade;
	
	@Column(nullable = false)
	private String dtNascimento;
	
	@ManyToMany(mappedBy = "listAutor")
	private List<Book>listLivro;

	public long getAutorId() {
		return autorId;
	}

	public void setAutorId(long autorId) {
		this.autorId = autorId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public List<Book> getListLivro() {
		return listLivro;
	}

	public void setListLivro(List<Book> listLivro) {
		this.listLivro = listLivro;
	}
	

}