/**
 * 
 */
package com.portfolio.management.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.portfolio.management.entity.KPI;
import com.portfolio.management.entity.KPIData;

/**
 * Service interface for all transactions relating to a {@link KPI } and
 * {@link KPIData}
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface KPIService {
	/**
	 * The service method to get all {@link KPI} from the db associated to a
	 * particular project.
	 * 
	 * @param project-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and list of all
	 *         {@link KPI} entities.
	 */
	public ResponseEntity<List<KPI>> getAllKPIsForProjectId(long projectId);

	/**
	 * The service method to get a {@link KPI} from the db having particular KPI-id.
	 * 
	 * @param KPI-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and saved entity
	 *         {@link KPI} having particular KPI-id or {@link HttpStatus} 204.
	 */
	public ResponseEntity<KPI> getKpiById(long kpiId);

	/**
	 * The service method to save a {@link KPI} to the db.
	 * 
	 * @param {@link KPI} object and its associated project-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and saved entity
	 *         {@link KPI} or {@link HttpStatus} 304.
	 */
	public ResponseEntity<KPI> saveKPI(KPI kpi, long projectId);

	/**
	 * The service method to update a {@link KPI} in the db.
	 * 
	 * @param {@link KPI} object and KPI-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and updated
	 *         entity {@link KPI} or else {@link HttpStatus} 304.
	 */
	public ResponseEntity<KPI> updateKPI(KPI kpi, long kpiId);

	/**
	 * The service method to delete if found, a {@link KPI} with given KPI-id.
	 * 
	 * @param KPI-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 204.
	 */
	public ResponseEntity<KPI> deleteKPI(long kpiId);

	/**
	 * The service method to get all {@link KPIData} from the db.
	 * 
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and list of all
	 *         {@link KPIData} entities.
	 */
	public ResponseEntity<List<KPIData>> getAllKPIDataforKpiId(long kpiId);

	/**
	 * The service method to get a {@link KPIData} from the db having particular
	 * KPIData-id.
	 * 
	 * @param KPI-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and saved entity
	 *         {@link KPIData} having particular KPI-id or {@link HttpStatus} 204.
	 */
	public ResponseEntity<KPIData> getKpiDataById(long kpiDataId);

	/**
	 * The service method to save a {@link KPIData} to the db associated to a
	 * particular {@link KPI}
	 * 
	 * @param {@link KPIData} object and KPI-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and saved entity
	 *         {@link KPIData}.
	 */
	public ResponseEntity<KPIData> saveKpiData(KPIData KPIData, long kpiId);

	/**
	 * The service method to update a {@link KPIData} in the db.
	 * 
	 * @param {@link KPIData} object and KPIData-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and updated
	 *         entity {@link KPIData} or else {@link HttpStatus} 304.
	 */
	public ResponseEntity<KPIData> updateKPIData(KPIData kpiData, long kpiDataId);

	/**
	 * The service method to delete if found, a {@link KPIData} with given KPI-id.
	 * 
	 * @param KPIData-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 204.
	 */
	public ResponseEntity<KPIData> deleteKPIData(long kpiDataId);

}
