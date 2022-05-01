/**
 * 
 */
package com.portfolio.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.UserContact;

/**
 * @author Sarath
 *
 */
public interface UserContactRepository extends JpaRepository<UserContact, Long> {

}
