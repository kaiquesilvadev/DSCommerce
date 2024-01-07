package com.kaiqueDev.DSCommerce.domain.dto.converso;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaiqueDev.DSCommerce.domain.dto.responce.UseDtoResponce;
import com.kaiqueDev.DSCommerce.domain.entites.User;

@Component
public class UserDtoConverso {

	@Autowired
	private ModelMapper mapper;

	public UseDtoResponce convertiEntity(User user) {
		return mapper.map(user, UseDtoResponce.class);
	}

}
