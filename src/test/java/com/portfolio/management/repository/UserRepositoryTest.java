/**
 * 
 */
package com.portfolio.management.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.portfolio.management.entity.User;

/**
 * @author Sarath
 *
 */
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testSaveUser() {
		User user = User.builder().firstName("Sarath").lastName("Madhu").userName("sam13113").password("Password@12").build();

		userRepository.save(user);
	}
	
	@Test
	public void testfindUser() {
		userRepository.findAll().forEach(System.out::println);
	}

}
