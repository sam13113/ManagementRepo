/**
 * 
 */
package com.portfolio.management.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.portfolio.management.entity.Country;
import com.portfolio.management.entity.OperatingEntity;

/**
 * Service interface for all transactions relating to a {@link OperatingEntity }
 * and {@link Country}
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface OperatingEntityService {

	/**
	 * The service method to get all {@link OperatingEntity} from the db associated
	 * to a particular {@link Country}.
	 * 
	 * @param project-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and list of all
	 *         {@link OperatingEntity} entities.
	 */
	public ResponseEntity<List<OperatingEntity>> getAllOperatingEntitysForCountryId(long countryId);

	/**
	 * The service method to get a {@link OperatingEntity} from the db having
	 * particular OperatingEntity-id.
	 * 
	 * @param KPI-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and saved entity
	 *         {@link OperatingEntity} having particular OperatingEntity-id or
	 *         {@link HttpStatus} 204.
	 */
	public ResponseEntity<OperatingEntity> getOperatingEntityById(long operatingEntityId);

	/**
	 * The service method to save a {@link OperatingEntity} to the db.
	 * 
	 * @param {@link OperatingEntity} object and its associated Country-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and saved entity
	 *         {@link OperatingEntity} or {@link HttpStatus} 304.
	 */
	public ResponseEntity<OperatingEntity> saveOperatingEntity(OperatingEntity operatingEntity, long countryId);

	/**
	 * The service method to update a {@link OperatingEntity} in the db.
	 * 
	 * @param {@link OperatingEntity} object and OperatingEntity-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and updated
	 *         entity {@link OperatingEntity} or else {@link HttpStatus} 304.
	 */
	public ResponseEntity<OperatingEntity> updateOperatingEntity(OperatingEntity operatingEntity,
			long operatingEntityId);

	/**
	 * The service method to delete if found, a {@link OperatingEntity} with given
	 * OperatingEntity-id.
	 * 
	 * @param OperatingEntity-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 204.
	 */
	public ResponseEntity<OperatingEntity> deleteOperatingEntity(long operatingEntityId);

}
