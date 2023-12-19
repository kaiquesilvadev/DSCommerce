package com.kaiqueDev.DSCommerce.api.exceptionHandler;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiErro {

	private OffsetDateTime timestamp;
	private Integer status;
	private String erro;
	private String path;
}
