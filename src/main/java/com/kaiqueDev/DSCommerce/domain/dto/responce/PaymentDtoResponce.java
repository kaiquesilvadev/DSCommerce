package com.kaiqueDev.DSCommerce.domain.dto.responce;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDtoResponce {

	private Long id;
	private Instant moment;
}
