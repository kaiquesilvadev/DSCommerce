package com.kaiqueDev.DSCommerce.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaiqueDev.DSCommerce.domain.dto.responce.UseDtoResponce;
import com.kaiqueDev.DSCommerce.domain.services.UserSecurityService;

@RestController
@RequestMapping("/users")
public class UserControlle {

	@Autowired
	private UserSecurityService service;

	@GetMapping("/me")
	public UseDtoResponce getMe() {
		return service.getME();
	}

}
