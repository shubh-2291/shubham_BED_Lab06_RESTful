package com.studentmanagement.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.studentmanagement.entity.Role;
import com.studentmanagement.entity.User;
import com.studentmanagement.service.UserDetailDecoratorInterface;

public class UserDetailDecorator implements UserDetails, UserDetailDecoratorInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	User user;

	public UserDetailDecorator(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> role = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		for (Role roles : role) {
			authorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.getAccountExpiryDate().isAfter(LocalDate.now())?true:false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.getAccountLockedStatus()==1?true:false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.getCredentialsExpiryDate().isAfter(LocalDate.now())?true:false;
	}

	@Override
	public boolean isEnabled() {
		return user.getEnabledStatus()==1?true:false;
	}

}
