/**
 * 
 */
package com.portfolio.management.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.management.entity.User;
import com.portfolio.management.repository.RoleRepository;
import com.portfolio.management.repository.UserContactRepository;
import com.portfolio.management.repository.UserRepository;
import com.portfolio.management.service.UserService;

/**
 * @author Sarath
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private UserContactRepository userContactRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			UserContactRepository userContactRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userContactRepository = userContactRepository;
	}

	@Override
	public ResponseEntity<User> saveUser(User user) {
		user.setPassword("password123");
		user.setRoles(Collections.singletonList(roleRepository.findByName("USER")));
		return new ResponseEntity<>(userRepository.saveAndFlush(user), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(this.userRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<User>> findUserByFirstname(String firstName) {
		return new ResponseEntity<>(this.userRepository.findAllByFirstName(firstName), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<User> getUserById(long id) {
		if (userRepository.findById(id).isPresent())
			return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<User> deleteUserById(long id) {
		this.userRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<User> updateUser(User user, long id) {
		if (id == user.getId()) {

			if (userRepository.findById(id).isPresent()) {
				User savedUser = userRepository.findById(id).get();
				if (user.getFirstName() != null)
					savedUser.setFirstName(user.getFirstName());
				if (user.getLastName() != null)
					savedUser.setLastName(user.getLastName());
				if (user.getUserName() != null)
					savedUser.setUserName(user.getUserName());
				return new ResponseEntity<>(userRepository.saveAndFlush(savedUser), HttpStatus.ACCEPTED);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

}
