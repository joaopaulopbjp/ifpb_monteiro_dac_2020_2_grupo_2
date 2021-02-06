package com.atividade.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import lombok.Data;

@Entity
@Data
public class CentroDistribuicao {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long centroDistribuicaoID;
		
		private String nome;
		private Endereco endereco;
		
		@OneToMany
		@JoinColumn(name = "prateleiraID")
		
		
		public long getCentroDistribuicaoID() {
			return centroDistribuicaoID;
		}
		public void setCentroDistribuicaoID(long centroDistribuicaoID) {
			this.centroDistribuicaoID = centroDistribuicaoID;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Endereco getEndereco() {
			return endereco;
		}
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		
		
		
		
		
		
}
