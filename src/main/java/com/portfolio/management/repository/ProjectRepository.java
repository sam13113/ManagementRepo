/**
 * 
 */
package com.portfolio.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.Project;

/**
 * Repository interface for {@link Project} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
