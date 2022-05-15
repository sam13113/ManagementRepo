/**
 * 
 */
package com.portfolio.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.management.entity.ServiceOffering;
import com.portfolio.management.repository.OperatingEntityRepository;
import com.portfolio.management.repository.ServiceOfferingRepository;
import com.portfolio.management.service.ServiceOfferingService;

/**
 * The default implementation for {@link ServiceOfferingService}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Service
public class ServiceOfferingServiceImpl implements ServiceOfferingService {

	private ServiceOfferingRepository serviceOfferingRepository;
	private OperatingEntityRepository operatingEntityRepository;

	/**
	 * All arguments constructor with dependency injected repository objects.
	 */
	@Autowired
	public ServiceOfferingServiceImpl(ServiceOfferingRepository serviceOfferingRepository,
			OperatingEntityRepository operatingEntityRepository) {
		this.serviceOfferingRepository = serviceOfferingRepository;
		this.operatingEntityRepository = operatingEntityRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<List<ServiceOffering>> getAllServiceOfferingsForOEId(long oeId) {
		if (this.operatingEntityRepository.findById(oeId).isPresent()) {
			List<ServiceOffering> listOfServiceOfferings = this.serviceOfferingRepository
					.findAllByOperatingEntityId(oeId);
			return new ResponseEntity<>(listOfServiceOfferings, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<ServiceOffering> getServiceOfferingById(long serviceOfferingId) {
		if (this.serviceOfferingRepository.findById(serviceOfferingId).isPresent())
			return new ResponseEntity<>(this.serviceOfferingRepository.findById(serviceOfferingId).get(),
					HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<ServiceOffering> saveServiceOffering(ServiceOffering serviceOffering, long oeId) {
		if (this.operatingEntityRepository.findById(oeId).isPresent()) {
			serviceOffering.setOperatingEntity(this.operatingEntityRepository.findById(oeId).get());
			return new ResponseEntity<>(this.serviceOfferingRepository.saveAndFlush(serviceOffering),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<ServiceOffering> updateServiceOffering(ServiceOffering serviceOffering,
			long serviceOfferingId) {
		if (serviceOfferingId == serviceOffering.getId())
			if (this.serviceOfferingRepository.findById(serviceOfferingId).isPresent()) {
				ServiceOffering savedServiceOffering = this.serviceOfferingRepository.findById(serviceOfferingId).get();
				savedServiceOffering.setBusinessWeightage(serviceOffering.getBusinessWeightage());
				if (serviceOffering.getOperatingEntity() != null)
					savedServiceOffering.setOperatingEntity(serviceOffering.getOperatingEntity());
				if (serviceOffering.getServicedescription() != null)
					savedServiceOffering.setServicedescription(serviceOffering.getServicedescription());
				if (serviceOffering.getServiceName() != null)
					savedServiceOffering.setServiceName(serviceOffering.getServiceName());

				return new ResponseEntity<>(this.serviceOfferingRepository.saveAndFlush(savedServiceOffering),
						HttpStatus.ACCEPTED);
			}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<ServiceOffering> deleteServiceOffering(long serviceOfferingId) {
		if (this.serviceOfferingRepository.findById(serviceOfferingId).isPresent())
			this.serviceOfferingRepository.deleteById(serviceOfferingId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
