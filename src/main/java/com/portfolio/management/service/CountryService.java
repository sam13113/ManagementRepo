/**
 * 
 */
package com.portfolio.management.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.portfolio.management.entity.Country;

/**
 * Service interface for all transactions relating to a {@link Country }
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface CountryService {

	/**
	 * The service method to get all {@link Country} from the db associated to a
	 * particular id.
	 * 
	 * @param Country-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and
	 *         {@link Country} entity.
	 */
	public ResponseEntity<Country> getCountryForId(long countryId);

	/**
	 * The service method to save a {@link Country} to the db.
	 * 
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and saved entity
	 *         {@link Country} or {@link HttpStatus} 304.
	 */
	public ResponseEntity<Country> saveCountry(Country country);

	/**
	 * The service method to update a {@link Country} in the db.
	 * 
	 * @param {@link Country} object and Country-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and updated
	 *         entity {@link Country} or else {@link HttpStatus} 304.
	 */
	public ResponseEntity<Country> updateCountry(Country country, long countryId);

	/**
	 * The service method to delete if found, a {@link Country} with given
	 * Country-id.
	 * 
	 * @param Country-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 204.
	 */
	public ResponseEntity<Country> deleteCountry(long countryId);
}
