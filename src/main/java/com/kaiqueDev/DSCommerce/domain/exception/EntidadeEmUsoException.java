package com.kaiqueDev.DSCommerce.domain.exception;

public class EntidadeEmUsoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(Long id) {
		super(String.format(
				"A exclusão do ID %d não pode ser realizada, pois o mesmo está atualmente em uso por outras operações no sistema.",
				id));
	}
}