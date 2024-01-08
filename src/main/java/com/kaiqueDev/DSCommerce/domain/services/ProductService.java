package com.kaiqueDev.DSCommerce.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaiqueDev.DSCommerce.domain.Repositoris.ProductRepository;
import com.kaiqueDev.DSCommerce.domain.dto.converso.ProductDtoConverso;
import com.kaiqueDev.DSCommerce.domain.dto.request.ProductDtoRequest;
import com.kaiqueDev.DSCommerce.domain.entites.Product;
import com.kaiqueDev.DSCommerce.domain.exception.EntidadeEmUsoException;
import com.kaiqueDev.DSCommerce.domain.exception.EntidadeInexistenteException;
import com.kaiqueDev.DSCommerce.domain.exception.EntidadeNaoEncontradaException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private ProductDtoConverso converso;

    @Transactional(readOnly = true)
	public Page<Product> lista(String nome, Pageable pageable) {
		return repository.lista(nome, pageable);
	}

	/*
	 * TODO : trocar a Exception por uma mais generica depois
	 */

    @Transactional(readOnly = true)
    public Product buscaPorId(Long id) {
        Product entity = repository.buscaPorId(id).orElseThrow(() -> new EntidadeNaoEncontradaException(id));

      
        return entity;
    }
	/*
	 * TODO : adiciona logica pra validar categorias depois de de fazer CRUd de
	 * categorias
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public Product adicionar(ProductDtoRequest dtoRequest) {
		try {
			Product product = converso.convertiDto(dtoRequest);
			return repository.save(product);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeInexistenteException("Categories");
		}

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Product atualizar(ProductDtoRequest dtoRequest, Long id) {
		try {
			Product product = buscaPorId(id);
			product.getCategories().clear();
			converso.atualiza(dtoRequest, product);
			repository.flush();
			return repository.save(product);
		} catch (JpaObjectRetrievalFailureException e) {
			throw new EntidadeInexistenteException("Categories");
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		try {
			buscaPorId(id);
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		}

	}
}
