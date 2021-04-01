package com.atividade.main.exceptionhandler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.atividade.main.exceptionhandler.GeralExceptionHandler.Erro;
import com.atividade.main.service.exception.CategoriaExistException;

@ControllerAdvice
public class EntityException {
	
	@Autowired
	private MessageSource menssageSourse;
	private String mensagemUsuario="";
	private String mensagemDesenvolvedor="";
	
	
	@ExceptionHandler(CategoriaExistException.class)
	public ResponseEntity<Object> handCategoriaExist(CategoriaExistException ex){
		mensagemUsuario = menssageSourse.getMessage("categoria.existe", null, LocaleContextHolder.getLocale());
		mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);		
	}
	
	

}
