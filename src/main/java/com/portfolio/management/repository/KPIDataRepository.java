/**
 * 
 */
package com.portfolio.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.KPI;
import com.portfolio.management.entity.KPIData;

/**
 * Repository interface for {@link KPIData} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface KPIDataRepository extends JpaRepository<KPIData, Long> {
	/**
	 * A custom method to fetch all {@link KPIData}s from the repository associated
	 * to a particular {@link KPI}
	 * 
	 * @param KPI-Id to be searched in db.
	 * @return List of all {@link KPIData}s having the same project-id.
	 */
	public List<KPIData> findAllByKpiId(long kpiId);
}
