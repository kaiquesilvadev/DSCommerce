package com.kaiqueDev.DSCommerce.api.exceptionHandler;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kaiqueDev.DSCommerce.domain.exception.EntidadeEmUsoException;
import com.kaiqueDev.DSCommerce.domain.exception.EntidadeNaoEncontradaException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	private ResponseEntity<?> tratarEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex , HttpServletRequest request) {
		 ApiErro erro = ApiErro.builder().status(HttpStatus.NOT_FOUND.value())
		.path(request.getRequestURI())
		.timestamp(OffsetDateTime.now())
		.erro(ex.getMessage())
		.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(erro);
	}
	
	@ExceptionHandler(EntidadeEmUsoException.class)
	private ResponseEntity<?> tratarEntidadeEmUsoException(EntidadeEmUsoException ex , HttpServletRequest request) {
		 ApiErro erro = ApiErro.builder().status(HttpStatus.CONFLICT.value())
		.path(request.getRequestURI())
		.timestamp(OffsetDateTime.now())
		.erro(ex.getMessage())
		.build();
		
		return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(erro);
	}
}
