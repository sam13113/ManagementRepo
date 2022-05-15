/**
 * 
 */
package com.portfolio.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.management.entity.OperatingEntity;
import com.portfolio.management.entity.ServiceOffering;
import com.portfolio.management.service.ServiceOfferingService;

/**
 * This RestController is responsible for all end-points related to
 * {@link ServiceOffering} management.
 * 
 * @since V0.1
 * 
 * @author Sarath
 *
 */
@RestController
public class ServiceOfferingController {

	private ServiceOfferingService serviceOfferingService;

	/**
	 * Constructor for the {@code ServiceOfferingController} with dependency
	 * injection.
	 * 
	 * @param {@link ServiceOfferingService}
	 */
	@Autowired
	public ServiceOfferingController(ServiceOfferingService serviceOfferingService) {
		this.serviceOfferingService = serviceOfferingService;
	}

	/**
	 * This end-point is used to get all {@link ServiceOffering}s having a specific
	 * OE-id via get request.
	 * 
	 * @param as request param the {@link OperatingEntity}-id
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the list of {@link ServiceOffering} if present, else empty
	 *         response with HTTPStatus 204.
	 */
	@GetMapping(value = "/getAllServiceOfferings")
	public ResponseEntity<List<ServiceOffering>> getAllServiceOfferingsByOEId(@RequestParam(name = "oeId") long oeId) {
		return this.serviceOfferingService.getAllServiceOfferingsForOEId(oeId);
	}

	/**
	 * This end-point is used to get a {@link ServiceOffering} having a specific
	 * ServiceOffering-id via get request.
	 * 
	 * @param as request param the {@link OperatingEntity}-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the {@link ServiceOffering} if present, else empty response
	 *         with HTTPStatus 204.
	 */
	@GetMapping(value = "/getServiceOffering")
	public ResponseEntity<ServiceOffering> getServiceOfferingById(
			@RequestParam(name = "serviceOfferingId") long serviceOfferingId) {
		return this.serviceOfferingService.getServiceOfferingById(serviceOfferingId);
	}

	/**
	 * This end-point is used to save a {@link ServiceOffering} via post request
	 * corresponding to a specific OE-id.
	 * 
	 * @param the request body has the {@link ServiceOffering} body as a json body
	 *            and as request parameter {@link OperatingEntity}-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the saved {@link ServiceOffering}.
	 */
	@PostMapping(value = "/serviceOffering")
	public ResponseEntity<ServiceOffering> saveServiceOfferingforOEId(@RequestBody ServiceOffering serviceOffering,
			@RequestParam(name = "oeId") long oeId) {
		return this.serviceOfferingService.saveServiceOffering(serviceOffering, oeId);
	}

	/**
	 * This end-point is used to modify an existing {@link ServiceOffering}
	 * corresponding to a {@link ServiceOffering}-id via put request.
	 * 
	 * @param the request body has the {@link ServiceOffering} as a json and as
	 *            Request parameter the ServiceOffering-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the updated {@link ServiceOffering}.
	 */
	@PutMapping(value = "/serviceOffering")
	public ResponseEntity<ServiceOffering> updateServiceOfferingById(@RequestBody ServiceOffering serviceOffering,
			@RequestParam(name = "serviceOfferingId") long serviceOfferingId) {
		return this.serviceOfferingService.updateServiceOffering(serviceOffering, serviceOfferingId);
	}

	/**
	 * This end-point is used to delete a {@link ServiceOffering} having a
	 * ServiceOffering-id via delete request.
	 * 
	 * @param the request param has the ServiceOffering-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus}
	 *         204.
	 */
	@DeleteMapping(value = "/deleteServiceOffering")
	public ResponseEntity<ServiceOffering> deleteServiceOfferingById(
			@RequestParam(name = "serviceOfferingId") long id) {
		return this.serviceOfferingService.deleteServiceOffering(id);
	}
}
