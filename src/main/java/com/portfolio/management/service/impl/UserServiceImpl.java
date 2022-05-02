/**
 * 
 */
package com.portfolio.management.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.management.entity.User;
import com.portfolio.management.entity.UserContact;
import com.portfolio.management.repository.RoleRepository;
import com.portfolio.management.repository.UserContactRepository;
import com.portfolio.management.repository.UserRepository;
import com.portfolio.management.service.UserService;

/**
 * The default implementation for {@link UserService}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private UserContactRepository userContactRepository;

	/**
	 * All arguments constructor with dependency injected repository objects.
	 */
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			UserContactRepository userContactRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userContactRepository = userContactRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<User> saveUser(User user) {
		user.setPassword("password123");
		user.setRoles(Collections.singletonList(roleRepository.findByName("USER")));
		return new ResponseEntity<>(userRepository.saveAndFlush(user), HttpStatus.ACCEPTED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(this.userRepository.findAll(), HttpStatus.FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<List<User>> findUserByFirstname(String firstName) {
		return new ResponseEntity<>(this.userRepository.findAllByFirstName(firstName), HttpStatus.FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<User> getUserById(long id) {
		if (userRepository.findById(id).isPresent())
			return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<User> deleteUserById(long id) {
		this.userRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Set<UserContact>> getUserContactDetailsByUserId(long userId) {
		if (userRepository.findById(userId).isPresent()) {
			User savedUser = userRepository.findById(userId).get();
			Set<UserContact> userContactList = savedUser.getUserContacts();
			return new ResponseEntity<Set<UserContact>>(userContactList, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<UserContact> getUserContactDetailById(long userContactId) {
		if (userContactRepository.findById(userContactId).isPresent())
			return new ResponseEntity<>(userContactRepository.findById(userContactId).get(), HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<User> UpdateUserContactByUserId(Set<UserContact> userContactList, long userId) {
		if (userRepository.findById(userId).isPresent()) {
			User savedUser = userRepository.findById(userId).get();
			savedUser.getUserContacts().addAll(userContactList);
			return new ResponseEntity<>(userRepository.saveAndFlush(savedUser), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<UserContact> deleteUserContactById(long userContactId) {
		if (userContactRepository.findById(userContactId).isPresent())
			this.userContactRepository.deleteById(userContactId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
