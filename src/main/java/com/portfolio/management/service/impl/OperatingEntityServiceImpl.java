/**
 * 
 */
package com.portfolio.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.management.entity.OperatingEntity;
import com.portfolio.management.repository.CountryRepository;
import com.portfolio.management.repository.OperatingEntityRepository;
import com.portfolio.management.service.OperatingEntityService;

/**
 * The default implementation for {@link OperatingEntityService}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Service
public class OperatingEntityServiceImpl implements OperatingEntityService {

	private OperatingEntityRepository operatingEntityRepository;
	private CountryRepository countryRepository;

	/**
	 * All arguments constructor with dependency injected repository objects.
	 */
	@Autowired
	public OperatingEntityServiceImpl(OperatingEntityRepository operatingEntityRepository,
			CountryRepository countryRepository) {
		this.operatingEntityRepository = operatingEntityRepository;
		this.countryRepository = countryRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<List<OperatingEntity>> getAllOperatingEntitysForCountryId(long countryId) {
		if (countryRepository.findById(countryId).isPresent()) {
			List<OperatingEntity> listOfOperatingEntitys = this.operatingEntityRepository.findAllByCountryId(countryId);
			return new ResponseEntity<>(listOfOperatingEntitys, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<OperatingEntity> getOperatingEntityById(long operatingEntityId) {
		if (operatingEntityRepository.findById(operatingEntityId).isPresent())
			return new ResponseEntity<>(operatingEntityRepository.findById(operatingEntityId).get(), HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<OperatingEntity> saveOperatingEntity(OperatingEntity operatingEntity, long countryId) {
		if (countryRepository.findById(countryId).isPresent()) {
			operatingEntity.setCountry(this.countryRepository.findById(countryId).get());
			return new ResponseEntity<>(this.operatingEntityRepository.saveAndFlush(operatingEntity),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<OperatingEntity> updateOperatingEntity(OperatingEntity operatingEntity,
			long operatingEntityId) {
		if (operatingEntityId == operatingEntity.getId())
			if (operatingEntityRepository.findById(operatingEntityId).isPresent()) {
				OperatingEntity savedOE = this.operatingEntityRepository.findById(operatingEntityId).get();
				if (operatingEntity.getEntityName() != null)
					savedOE.setEntityName(operatingEntity.getEntityName());
				if (operatingEntity.getCountry() != null)
					savedOE.setCountry(operatingEntity.getCountry());

				return new ResponseEntity<>(this.operatingEntityRepository.saveAndFlush(savedOE), HttpStatus.ACCEPTED);
			}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<OperatingEntity> deleteOperatingEntity(long operatingEntityId) {
		if (this.operatingEntityRepository.findById(operatingEntityId).isPresent())
			this.operatingEntityRepository.deleteById(operatingEntityId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
