/**
 * 
 */
package com.portfolio.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.Country;

/**
 * Repository interface for {@link Country} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface CountryRepository extends JpaRepository<Country, Long> {

}
