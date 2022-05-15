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

import com.portfolio.management.entity.Country;
import com.portfolio.management.entity.OperatingEntity;
import com.portfolio.management.service.OperatingEntityService;

/**
 * This RestController is responsible for all end-points related to
 * {@link OperatingEntity} management
 * 
 * @since V0.1
 * 
 * @author Sarath
 *
 */
@RestController
public class OperatingEntityController {

	private OperatingEntityService operatingEntityService;

	/**
	 * Constructor for the {@code OperatingEntityController} with dependency
	 * injection.
	 * 
	 * @param {@link OperatingEntityService}
	 */
	@Autowired
	public OperatingEntityController(OperatingEntityService operatingEntityService) {
		this.operatingEntityService = operatingEntityService;
	}

	/**
	 * This end-point is used to get all {@link OperatingEntity}s having a specific
	 * Country-id via get request.
	 * 
	 * @param as request param the country-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the list of {@link OperatingEntity} if present, else empty
	 *         response with HTTPStatus 204.
	 */
	@GetMapping(value = "/getAllOE")
	public ResponseEntity<List<OperatingEntity>> getAllOEsByCountryId(
			@RequestParam(name = "countryId") long countryId) {
		return this.operatingEntityService.getAllOperatingEntitysForCountryId(countryId);
	}

	/**
	 * This end-point is used to get a {@link OperatingEntity} having a specific
	 * OperatingEntity-id via get request.
	 * 
	 * @param as request param the OperatingEntity-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the {@link OperatingEntity} if present, else empty response
	 *         with HTTPStatus 204.
	 */
	@GetMapping(value = "/getOE")
	public ResponseEntity<OperatingEntity> getOperatingEntityById(@RequestParam(name = "oeId") long operatingEntityId) {
		return this.operatingEntityService.getOperatingEntityById(operatingEntityId);
	}

	/**
	 * This end-point is used to save a {@link OperatingEntity} via post request
	 * corresponding to a specific country-id.
	 * 
	 * @param the request body has the {@link OperatingEntity} body as a json body
	 *            and as request parameter {@link Country}-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the saved {@link OperatingEntity}.
	 */
	@PostMapping(value = "/oe")
	public ResponseEntity<OperatingEntity> saveOperatingEntityforCountryId(@RequestBody OperatingEntity operatingEntity,
			@RequestParam(name = "countryId") long countryId) {
		return this.operatingEntityService.saveOperatingEntity(operatingEntity, countryId);
	}

	/**
	 * This end-point is used to modify an existing {@link OperatingEntity}
	 * corresponding to a {@link OperatingEntity}-id via put request.
	 * 
	 * @param the request body has the {@link OperatingEntity} as a json and as
	 *            Request parameter the OperatingEntity-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the updated {@link OperatingEntity}.
	 */
	@PutMapping(value = "/oe")
	public ResponseEntity<OperatingEntity> updateOperatingEntityById(@RequestBody OperatingEntity operatingEntity,
			@RequestParam(name = "oeId") long oeId) {
		return this.operatingEntityService.updateOperatingEntity(operatingEntity, oeId);
	}

	/**
	 * This end-point is used to delete a {@link OperatingEntity} having a
	 * OperatingEntity-id via delete request.
	 * 
	 * @param the request param has the OperatingEntity-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus}
	 *         204.
	 */
	@DeleteMapping(value = "/deleteOE")
	public ResponseEntity<OperatingEntity> deleteKPIById(@RequestParam(name = "oeId") long id) {
		return this.operatingEntityService.deleteOperatingEntity(id);
	}
}
