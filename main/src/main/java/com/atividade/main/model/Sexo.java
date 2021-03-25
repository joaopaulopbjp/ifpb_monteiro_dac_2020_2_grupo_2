package com.atividade.main.model;

import lombok.Getter;

@Getter
public enum Sexo {
	
	M("Masculino"), F("Feminino");
	
	private String sexo;
	
	Sexo(String sexo){
		this.sexo=sexo;
	}
	

}
