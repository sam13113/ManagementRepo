/**
 * 
 */
package com.portfolio.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.Country;
import com.portfolio.management.entity.OperatingEntity;

/**
 * Repository interface for {@link OperatingEntity} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface OperatingEntityRepository extends JpaRepository<OperatingEntity, Long> {

	/**
	 * A custom method to fetch all {@link OperatingEntity}s from the repository
	 * associated to a particular {@link Country}
	 * 
	 * @param project-Id to be searched in db.
	 * @return List of all {@link OperatingEntity}s having the same country-id.
	 */
	public List<OperatingEntity> findAllByCountryId(long countryId);
}
