/**
 * 
 */
package com.portfolio.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.OperatingEntity;
import com.portfolio.management.entity.ServiceOffering;

/**
 * Repository interface for {@link ServiceOffering} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering, Long> {

	/**
	 * A custom method to fetch all {@link ServiceOffering}s from the repository
	 * associated to a particular {@link OperatingEntity}
	 * 
	 * @param project-Id to be searched in db.
	 * @return List of all {@link ServiceOffering}s having the same
	 *         OperatingEntity-id.
	 */
	public List<ServiceOffering> findAllByOperatingEntityId(long oeId);
}
