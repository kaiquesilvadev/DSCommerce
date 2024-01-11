package com.kaiqueDev.DSCommerce.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaiqueDev.DSCommerce.domain.Repositoris.OrderRepository;
import com.kaiqueDev.DSCommerce.domain.dto.converso.OrderDtoConverso;
import com.kaiqueDev.DSCommerce.domain.dto.request.OrderDtoRequest;
import com.kaiqueDev.DSCommerce.domain.entites.Order;
import com.kaiqueDev.DSCommerce.domain.entites.Product;
import com.kaiqueDev.DSCommerce.domain.exception.EntidadeNaoEncontradaException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private OrderDtoConverso converso;

	@Autowired
	private UserSecurityService userService;

	@Autowired
	private ProductService productService;

	@Transactional(readOnly = true)
	public Order findById(Long id) {
		Order order = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(id));

		/*
		 * Valida se o pedido em questão pertence ao usuário atualmente logado ou se o
		 * usuário possui privilégios de administrador.
		 */
		userService.validateSelfOrAdmin(order.getClient().getId());

		return order;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Order adicionar(OrderDtoRequest dtoRequest) {

		Order entity = converso.convertiDTO(dtoRequest);
		converteItens(entity);
		entity.aguardandoPagamento();
		entity.salvaData();
		entity.setClient(userService.authenticated());
		return repository.save(entity);
	}

	private void converteItens(Order entity) {
		entity.getItems().forEach(item -> {
			Product product = productService.buscaPorId(item.getProduct().getId());
			item.setPrice(product.getPrice());
			item.setOrder(entity);
			item.setOrderProduct(product);
		});
	}
}
