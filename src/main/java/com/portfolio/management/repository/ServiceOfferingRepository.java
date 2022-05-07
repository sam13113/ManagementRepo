/**
 * 
 */
package com.portfolio.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.ServiceOffering;

/**
 * Repository interface for {@link ServiceOffering} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering, Long> {

}
