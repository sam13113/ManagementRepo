/**
 * 
 */
package com.portfolio.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.OperatingEntity;

/**
 * Repository interface for {@link OperatingEntity} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface OperatingEntityRepository extends JpaRepository<OperatingEntity, Long> {

}
