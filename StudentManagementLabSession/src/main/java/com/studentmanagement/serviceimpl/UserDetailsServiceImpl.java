package com.studentmanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.studentmanagement.repository.UserRepository;
import com.studentmanagement.service.UserDetailService;

public class UserDetailsServiceImpl implements UserDetailsService, UserDetailService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (userRepository.findByUsername(username) == null) {
			throw new UsernameNotFoundException("Could Not find user");
		}
		return new UserDetailDecorator(userRepository.findByUsername(username));
	}

}
