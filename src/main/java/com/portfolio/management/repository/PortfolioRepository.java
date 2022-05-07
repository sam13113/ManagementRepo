/**
 * 
 */
package com.portfolio.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.entity.Portfolio;

/**
 * Repository interface for {@link Portfolio} entity.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
