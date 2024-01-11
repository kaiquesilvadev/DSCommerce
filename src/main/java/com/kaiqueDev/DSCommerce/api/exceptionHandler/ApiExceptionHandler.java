package com.kaiqueDev.DSCommerce.api.exceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kaiqueDev.DSCommerce.api.exceptionHandler.ApiErro.Field;
import com.kaiqueDev.DSCommerce.api.exceptionHandler.enuns.ProblemType;
import com.kaiqueDev.DSCommerce.domain.exception.CredencialInvalidaException;
import com.kaiqueDev.DSCommerce.domain.exception.EntidadeEmUsoException;
import com.kaiqueDev.DSCommerce.domain.exception.EntidadeInexistenteException;
import com.kaiqueDev.DSCommerce.domain.exception.EntidadeNaoEncontradaException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatusCode statusCode, WebRequest request) {
		String ErrorManager = ((HttpStatus) statusCode).getReasonPhrase();

		if (body == null) {
			body = ApiErro.builder().status(statusCode.value()).build();
		} else if (body instanceof String) {
			body = ApiErro.builder().status(statusCode.value()).build();

		}

		return super.handleExceptionInternal(ex, body, headers, statusCode, request);
	}

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	private ResponseEntity<?> tratarEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex,
			HttpServletRequest request) {
		ApiErro erro = ApiErro.builder().status(HttpStatus.NOT_FOUND.value()).path(request.getRequestURI())
				.timestamp(OffsetDateTime.now()).erro(ex.getMessage()).build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(erro);
	}

	@ExceptionHandler(EntidadeInexistenteException.class)
	private ResponseEntity<?> tratarEntidadeInexistenteException(EntidadeInexistenteException ex,
			HttpServletRequest request) {
		ApiErro erro = ApiErro.builder().status(HttpStatus.BAD_REQUEST.value()).path(request.getRequestURI())
				.timestamp(OffsetDateTime.now()).erro(ex.getMessage()).build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(erro);
	}

	@ExceptionHandler(EntidadeEmUsoException.class)
	private ResponseEntity<?> tratarEntidadeEmUsoException(CredencialInvalidaException ex, HttpServletRequest request) {
		ApiErro erro = ApiErro.builder().status(HttpStatus.CONFLICT.value()).path(request.getRequestURI())
				.timestamp(OffsetDateTime.now()).erro(ex.getMessage()).build();

		return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(erro);
	}
	
	@ExceptionHandler(CredencialInvalidaException.class)
	private ResponseEntity<?> tratarCredencialInvalidaException(CredencialInvalidaException ex, HttpServletRequest request) {
		ApiErro erro = ApiErro.builder()
				.status(HttpStatus.FORBIDDEN.value())
				.path(request.getRequestURI())
				.timestamp(OffsetDateTime.now())
				.erro(ex.getMessage()).build();

		return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(erro);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<Field> Filter = ex.getBindingResult().getFieldErrors().stream().map((x) -> {
			String messagem = messageSource.getMessage(x, LocaleContextHolder.getLocale());

			return ApiErro.Field.builder().nome(x.getField()).Message(messagem).build();

		}).collect(Collectors.toList());

		ApiErro erro = ApiErro.builder().path(ProblemType.PARAMETRO_INVALIDO.getUrl()).timestamp(OffsetDateTime.now())
				.erro("Um ou mais campos estão inválidos").fields(Filter).build();

		return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}
}
