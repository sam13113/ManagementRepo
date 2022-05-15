/**
 * 
 */
package com.portfolio.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.Portfolio;
import com.portfolio.management.entity.Project;

/**
 * Repository interface for {@link Project} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

	/**
	 * A custom method to fetch all {@link Project}s from the repository associated
	 * to a particular {@link Portfolio}
	 * 
	 * @param project-Id to be searched in db.
	 * @return List of all {@link Project}s having the same portfolio-id.
	 */
	public List<Project> findAllByPortfolioId(long portfolioId);
}
