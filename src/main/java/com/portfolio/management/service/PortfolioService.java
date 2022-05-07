/**
 * 
 */
package com.portfolio.management.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.portfolio.management.entity.Portfolio;

/**
 * Service interface for all transactions relating to a {@link Portfolio }
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface PortfolioService {

	/**
	 * The service method to get all {@link Portfolio} from the db associated to a
	 * particular project.
	 * 
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and list of all
	 *         {@link Portfolio} entities.
	 */
	public ResponseEntity<List<Portfolio>> getAllPortfolios();

	/**
	 * The service method to get a {@link Portfolio} from the db having particular
	 * Portfolio-id.
	 * 
	 * @param Portfolio-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and saved entity
	 *         {@link Portfolio} having particular Portfolio-id or
	 *         {@link HttpStatus} 204.
	 */
	public ResponseEntity<Portfolio> getPortfolioById(long portfolioId);

	/**
	 * The service method to save a {@link Portfolio} to the db.
	 * 
	 * @param {@link Portfolio} object
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and saved entity
	 *         {@link Portfolio} or {@link HttpStatus} 304.
	 */
	public ResponseEntity<Portfolio> savePortfolio(Portfolio portfolio);

	/**
	 * The service method to update a {@link Portfolio} in the db.
	 * 
	 * @param {@link Portfolio} object and Portfolio-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and updated
	 *         entity {@link Portfolio} or else {@link HttpStatus} 304.
	 */
	public ResponseEntity<Portfolio> updatePortfolio(Portfolio portfolio, long portfolioId);

	/**
	 * The service method to delete if found, a {@link Portfolio} with given
	 * Portfolio-id.
	 * 
	 * @param Portfolio-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 204.
	 */
	public ResponseEntity<Portfolio> deletePortfolio(long portfolioId);

}
