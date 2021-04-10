package com.atividade.main.repository.dto;

import org.springframework.beans.BeanUtils;

import com.atividade.main.model.Sexo;
import com.atividade.main.model.Usuario;
import com.atividade.main.model.Usuario_;

import lombok.Data;

@Data
public class UsuarioDTO {
	
	private Long userId;
	
	private String nome;
	
	private String email;
	
	private String celular;
	
	private String cpf;
	
	private String CPF;
	
	private Sexo sexo;
	
	public UsuarioDTO (Usuario usuario) {
		BeanUtils.copyProperties(usuario, this, Usuario_.USER_ID, Usuario_.SENHA);
	}
}
