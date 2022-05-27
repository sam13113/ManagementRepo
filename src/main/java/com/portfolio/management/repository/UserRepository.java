/**
 * 
 */
package com.portfolio.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.management.entity.User;

/**
 * Repository interface for {@link User} entity.
 * 
 * @author Sarath
 * @since 0.1
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * A custom method to fetch all {@link User}s from the repository having
	 * particular firstName.
	 * 
	 * @param firstName to be searched in db.
	 * @return List of all {@link User}s having the firstName same as that of the
	 *         param.
	 */
	public List<User> findAllByFirstName(String firstName);

	/**
	 * A custom method to fetch a {@link User} from the repository having particular
	 * userName.
	 * 
	 * @param firstName to be searched in db.
	 * @return {@link User} having the userName same as that of the param.
	 */
	public User findByUserName(String userName);
}
