/**
 * 
 */
package com.portfolio.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.KPI;
import com.portfolio.management.entity.Project;

/**
 * Repository interface for {@link KPI} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface KPIRepository extends JpaRepository<KPI, Long> {
	/**
	 * A custom method to fetch all {@link KPI}s from the repository associated to a
	 * particular {@link Project}
	 * 
	 * @param project-Id to be searched in db.
	 * @return List of all {@link KPI}s having the same project-id.
	 */
	public List<KPI> findAllByProjectId(long projectId);

}
