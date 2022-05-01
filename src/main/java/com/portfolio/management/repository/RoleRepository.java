/**
 * 
 */
package com.portfolio.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.portfolio.management.entity.Role;

/**
 * @author Sarath
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByName(@Param("name") String name);
}
