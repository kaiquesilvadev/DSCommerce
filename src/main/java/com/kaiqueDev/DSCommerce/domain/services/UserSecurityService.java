package com.kaiqueDev.DSCommerce.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kaiqueDev.DSCommerce.domain.Repositoris.UserRepository;
import com.kaiqueDev.DSCommerce.domain.entites.Role;
import com.kaiqueDev.DSCommerce.domain.entites.User;
import com.kaiqueDev.DSCommerce.domain.project.UserDetailsProjection;

public class UserSecurityService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<UserDetailsProjection> result = userRepository.searchUserAndRolesByEmail(username);

		if(result.size() == 0) {
			throw new UsernameNotFoundException(" User not found");
		}
		
		User user = new User();
		user.setEmail(username);
		user.setPassword(result.get(0).getPassword());
		
		for (UserDetailsProjection Projection : result) {
			user.addRole(new Role(Projection.getRoleId() , Projection.getAuthority()));
		}
		
		return user;
	}
}
