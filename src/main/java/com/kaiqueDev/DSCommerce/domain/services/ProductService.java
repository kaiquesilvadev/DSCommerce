package com.kaiqueDev.DSCommerce.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kaiqueDev.DSCommerce.domain.Repositoris.ProductRepository;
import com.kaiqueDev.DSCommerce.domain.dto.converso.ProductDtoConverso;
import com.kaiqueDev.DSCommerce.domain.dto.request.ProductDtoRequest;
import com.kaiqueDev.DSCommerce.domain.entites.Product;
import com.kaiqueDev.DSCommerce.domain.exception.EntidadeEmUsoException;
import com.kaiqueDev.DSCommerce.domain.exception.EntidadeNaoEncontradaException;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private ProductDtoConverso converso;

	public Page<Product> lista(Pageable pageable) {
		return repository.findAll(pageable);
	}

	/*
	 * TODO : trocar a Exception por uma mais generica depois
	 */

	public Product buscaPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(id));
	}

	/*
	 * TODO : adiciona logica pra validar categorias depois de de fazer CRUd de
	 * categorias
	 */
	@Transactional
	public Product adicionar(ProductDtoRequest dtoRequest) {
		Product product = converso.convertiDto(dtoRequest);
		return repository.save(product);
	}

	@Transactional
	public Product atualizar(ProductDtoRequest dtoRequest, Long id) {
		Product product = buscaPorId(id);
		converso.atualiza(dtoRequest, product);
		return repository.save(product);
	}

	@Transactional
	public void delete(Long id) {
		try {
			buscaPorId(id);
			repository.deleteById(id);
			repository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		}

	}
}
