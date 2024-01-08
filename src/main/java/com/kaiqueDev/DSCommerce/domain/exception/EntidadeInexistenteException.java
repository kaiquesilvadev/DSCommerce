package com.kaiqueDev.DSCommerce.domain.exception;

public class EntidadeInexistenteException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EntidadeInexistenteException(String msg) {
		super(String.format("Existe algum ID incorreto no campo %s", msg));
	}
}
