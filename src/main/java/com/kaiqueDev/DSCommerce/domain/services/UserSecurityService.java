package com.kaiqueDev.DSCommerce.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaiqueDev.DSCommerce.domain.Repositoris.UserRepository;
import com.kaiqueDev.DSCommerce.domain.dto.converso.UserDtoConverso;
import com.kaiqueDev.DSCommerce.domain.dto.responce.UseDtoResponce;
import com.kaiqueDev.DSCommerce.domain.entites.Role;
import com.kaiqueDev.DSCommerce.domain.entites.User;
import com.kaiqueDev.DSCommerce.domain.project.UserDetailsProjection;

@Service
public class UserSecurityService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDtoConverso converso;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<UserDetailsProjection> result = userRepository.searchUserAndRolesByEmail(username);

		if (result.size() == 0) {
			throw new UsernameNotFoundException(" User not found");
		}

		User user = new User();
		user.setEmail(username);
		user.setPassword(result.get(0).getPassword());

		for (UserDetailsProjection Projection : result) {
			user.addRole(new Role(Projection.getRoleId(), Projection.getAuthority()));
		}

		return user;
	}

	/*
	 * Retorna o usuário autenticado. Utiliza o SecurityContextHolder para obter as
	 * informações de autenticação, em seguida, extrai o nome de usuário a partir do
	 * token JWT. Se ocorrer alguma exceção durante esse processo, lança uma
	 * UsernameNotFoundException.
	 */
	protected User authenticated() {

		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
			String username = jwtPrincipal.getClaim("username");

			return userRepository.findByEmail(username).get();
		} catch (Exception e) {
			throw new UsernameNotFoundException(" User not found");
		}

	}

	@Transactional(readOnly = true)
	public UseDtoResponce getME() {

		User user = authenticated();
		return converso.convertiEntity(user);
	}
}
