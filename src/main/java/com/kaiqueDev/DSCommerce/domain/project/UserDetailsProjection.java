package com.kaiqueDev.DSCommerce.domain.project;

public interface UserDetailsProjection {

	String getUsername();

	String getPassword();

	Long getRoleId();

	String getAuthority();
}