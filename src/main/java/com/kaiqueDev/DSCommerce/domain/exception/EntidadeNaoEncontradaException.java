package com.kaiqueDev.DSCommerce.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String msg) {
		super(msg);
	}
	
	public EntidadeNaoEncontradaException(Long id) {
		this(String.format("Não foi possível encontrar o código com a identificação '%d'. Verifique se o ID está correto e tente novamente.", id));
	}
}
