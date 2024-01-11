package com.kaiqueDev.DSCommerce.domain.exception;

public class CredencialInvalidaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CredencialInvalidaException() {
		super("Desculpe, você não tem permissão para acessar esta página");
	}
}
