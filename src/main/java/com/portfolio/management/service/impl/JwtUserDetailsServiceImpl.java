/**
 * 
 */
package com.portfolio.management.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.management.entity.User;
import com.portfolio.management.repository.UserRepository;

/**
 * @author Sarath
 *
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	public JwtUserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUserName(username);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
					new ArrayList<>());
		}
		throw new UsernameNotFoundException("User not found with username: " + username);
	}

}
