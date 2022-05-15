/**
 * 
 */
package com.portfolio.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.KPI;
import com.portfolio.management.entity.Portfolio;
import com.portfolio.management.entity.ServiceOffering;

/**
 * Repository interface for {@link Portfolio} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

	/**
	 * A custom method to fetch all {@link Portfolio}s from the repository
	 * associated to a particular {@link ServiceOffering}
	 * 
	 * @param project-Id to be searched in db.
	 * @return List of all {@link KPI}s having the same project-id.
	 */
	public List<Portfolio> findAllByServiceOfferingId(long serviceOfferingId);
}
