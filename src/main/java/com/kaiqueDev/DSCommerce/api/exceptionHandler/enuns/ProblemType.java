package com.kaiqueDev.DSCommerce.api.exceptionHandler.enuns;

import lombok.Getter;

@Getter
public enum ProblemType {


	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro Inválido");

	private String url;
	private String title;

	ProblemType(String path, String title) {
				this.url = "https//kaique.com.br" + path;
				this.title = title;
			}

}
