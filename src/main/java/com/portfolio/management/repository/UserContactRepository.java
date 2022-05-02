/**
 * 
 */
package com.portfolio.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.UserContact;

/**
 * Repository interface for {@link UserContact} entity.
 * 
 * @author Sarath
 * @since 0.1
 */
public interface UserContactRepository extends JpaRepository<UserContact, Long> {

}
