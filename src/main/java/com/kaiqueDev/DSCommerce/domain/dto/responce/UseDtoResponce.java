package com.kaiqueDev.DSCommerce.domain.dto.responce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.kaiqueDev.DSCommerce.domain.dto.referencias.RolesMinDtoRef;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UseDtoResponce {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private LocalDate birthDate;

	List<RolesMinDtoRef> roles = new ArrayList<>();
}
