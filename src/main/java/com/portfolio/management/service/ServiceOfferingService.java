/**
 * 
 */
package com.portfolio.management.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.portfolio.management.entity.OperatingEntity;
import com.portfolio.management.entity.ServiceOffering;

/**
 * Service interface for all transactions relating to a {@link ServiceOfferings
 * }
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface ServiceOfferingService {

	/**
	 * The service method to get all {@link ServiceOffering} from the db associated
	 * to a particular {@link OperatingEntity}.
	 * 
	 * @param OperatingEntity-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and list of all
	 *         {@link ServiceOffering} entities.
	 */
	public ResponseEntity<List<ServiceOffering>> getAllServiceOfferingsForOEId(long oeId);

	/**
	 * The service method to get a {@link ServiceOffering} from the db having
	 * particular ServiceOffering-id.
	 * 
	 * @param ServiceOffering-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and saved entity
	 *         {@link ServiceOffering} having particular ServiceOffering-id or
	 *         {@link HttpStatus} 204.
	 */
	public ResponseEntity<ServiceOffering> getServiceOfferingById(long serviceOfferingId);

	/**
	 * The service method to save a {@link ServiceOffering} to the db.
	 * 
	 * @param {@link ServiceOffering} object and its associated
	 *               {@link OperatingEntity}-id
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and saved entity
	 *         {@link ServiceOffering} or {@link HttpStatus} 304.
	 */
	public ResponseEntity<ServiceOffering> saveServiceOffering(ServiceOffering serviceOffering, long oeId);

	/**
	 * The service method to update a {@link ServiceOffering} in the db.
	 * 
	 * @param {@link ServiceOffering} object and ServiceOffering-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and updated
	 *         entity {@link ServiceOffering} or else {@link HttpStatus} 304.
	 */
	public ResponseEntity<ServiceOffering> updateServiceOffering(ServiceOffering serviceOffering,
			long serviceOfferingId);

	/**
	 * The service method to delete if found, a {@link ServiceOffering} with given
	 * ServiceOffering-id.
	 * 
	 * @param ServiceOffering-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 204.
	 */
	public ResponseEntity<ServiceOffering> deleteServiceOffering(long serviceOfferingId);
}
