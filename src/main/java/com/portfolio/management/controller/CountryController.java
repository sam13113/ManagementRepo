/**
 * 
 */
package com.portfolio.management.controller;

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
import com.portfolio.management.service.CountryService;

/**
 * This RestController is responsible for all end-points related to
 * {@link Country}
 * 
 * @since V0.1
 * 
 * @author Sarath
 *
 */
@RestController
public class CountryController {

	private CountryService countryService;

	/**
	 * Constructor for the {@code CountryController} with dependency injection.
	 * 
	 * @param {@link CountryService}
	 */
	@Autowired
	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}

	/**
	 * This end-point is used to get a {@link Country} having a specific Country-id
	 * via get request.
	 * 
	 * @param as request param the Country-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the {@link Country} if present, else empty response with
	 *         HTTPStatus 204.
	 */
	@GetMapping(value = "/getCountry")
	public ResponseEntity<Country> getCountryById(@RequestParam(name = "countryId") long CountryId) {
		return this.countryService.getCountryForId(CountryId);
	}

	/**
	 * This end-point is used to save a {@link Country} via post request.
	 * 
	 * @param the request body has the {@link Country} body as a json body.
	 * 
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the saved {@link Country}.
	 */
	@PostMapping(value = "/country")
	public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
		return this.countryService.saveCountry(country);
	}

	/**
	 * This end-point is used to modify an existing {@link Country} corresponding to
	 * a {@link Country}-id via put request.
	 * 
	 * @param the request body has the {@link Country} as a json and as Request
	 *            parameter the Country-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the updated {@link Country}.
	 */
	@PutMapping(value = "/country")
	public ResponseEntity<Country> updateCountryById(@RequestBody Country country,
			@RequestParam(name = "countryId") long countryId) {
		return this.countryService.updateCountry(country, countryId);
	}

	/**
	 * This end-point is used to delete a {@link Country} having a Country-id via
	 * delete request.
	 * 
	 * @param the request param has the Country-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus}
	 *         204.
	 */
	@DeleteMapping(value = "/deleteCountry")
	public ResponseEntity<Country> deleteCountryById(@RequestParam(name = "countryId") long id) {
		return this.countryService.deleteCountry(id);
	}

}
