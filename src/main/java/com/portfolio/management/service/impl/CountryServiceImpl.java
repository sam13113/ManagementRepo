/**
 * 
 */
package com.portfolio.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.management.entity.Country;
import com.portfolio.management.repository.CountryRepository;
import com.portfolio.management.service.CountryService;

/**
 * The default implementation for {@link CountryService}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Service
public class CountryServiceImpl implements CountryService {

	private CountryRepository countryRepository;

	/**
	 * All arguments constructor with dependency injected repository objects.
	 */
	@Autowired
	public CountryServiceImpl(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Country> getCountryForId(long countryId) {
		if (countryRepository.findById(countryId).isPresent())
			return new ResponseEntity<>(countryRepository.findById(countryId).get(), HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Country> saveCountry(Country country) {
		return new ResponseEntity<>(this.countryRepository.saveAndFlush(country), HttpStatus.ACCEPTED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Country> updateCountry(Country country, long countryId) {
		if (country.getId() == countryId)
			if (countryRepository.findById(countryId).isPresent()) {
				Country savedCountry = countryRepository.findById(countryId).get();
				if (country.getContryName() != null)
					savedCountry.setContryName(country.getContryName());
				if (country.getCountryCode() != null)
					savedCountry.setCountryCode(country.getCountryCode());

				return new ResponseEntity<>(this.countryRepository.saveAndFlush(savedCountry), HttpStatus.ACCEPTED);
			}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Country> deleteCountry(long countryId) {
		if (countryRepository.findById(countryId).isPresent())
			this.countryRepository.deleteById(countryId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
