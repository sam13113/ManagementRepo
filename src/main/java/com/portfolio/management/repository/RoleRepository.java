/**
 * 
 */
package com.portfolio.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.portfolio.management.entity.Role;

/**
 * Repository interface for {@link Role} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByName(@Param("name") String name);
}
