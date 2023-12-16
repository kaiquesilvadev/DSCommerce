package com.kaiqueDev.DSCommerce.entites;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;

	/*
	 * Através da anotação '@MapsId' em conjunto com '@OneToOne', o JPA configura o
	 * relacionamento, transformando o atributo 'order' em uma chave estrangeira
	 * ('Order_id') na tabela correspondente. Essa abordagem simplifica a
	 * associação, utilizando o mesmo identificador para ambas as entidades.
	 */
	@OneToOne
	@MapsId
	@JoinColumn(name = "order_id")
	private Order order;
}
