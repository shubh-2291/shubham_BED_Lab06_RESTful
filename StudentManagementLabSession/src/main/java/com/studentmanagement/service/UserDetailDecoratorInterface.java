package com.studentmanagement.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface UserDetailDecoratorInterface {

	Collection<? extends GrantedAuthority> getAuthorities();

	String getPassword();

	String getUsername();

	boolean isAccountNonExpired();

	boolean isAccountNonLocked();

	boolean isCredentialsNonExpired();

	boolean isEnabled();

}