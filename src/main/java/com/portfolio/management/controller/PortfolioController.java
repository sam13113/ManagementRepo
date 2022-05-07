/**
 * 
 */
package com.portfolio.management.controller;

import java.util.List;

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

import com.portfolio.management.entity.Portfolio;
import com.portfolio.management.service.PortfolioService;

/**
 * This RestController is responsible for all end-points related to
 * {@link Portfolio}
 * 
 * @since V0.1
 * 
 * @author Sarath
 *
 */
@RestController
public class PortfolioController {

	private PortfolioService portfolioService;

	/**
	 * Constructor for the {@code PortfolioController} with dependency injection.
	 * 
	 * @param {@link PortfolioService}
	 */
	@Autowired
	public PortfolioController(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;
	}

	/**
	 * This end-point is used to get all {@link Portfolio}s from the db.
	 * 
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the list of {@link Portfolio} if present, else empty response
	 *         with HTTPStatus 204.
	 */
	@GetMapping(value = "/getAllPortfolio")
	public ResponseEntity<List<Portfolio>> getAllPortfolios() {
		return this.portfolioService.getAllPortfolios();
	}

	/**
	 * This end-point is used to get a {@link Portfolio} having a specific
	 * Portfolio-id via get request.
	 * 
	 * @param as request param the Portfolio-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the {@link Portfolio} if present, else empty response with
	 *         HTTPStatus 204.
	 */
	@GetMapping(value = "/getPortfolio")
	public ResponseEntity<Portfolio> getKPIById(@RequestParam(name = "portfolioId") long portfolioId) {
		return this.portfolioService.getPortfolioById(portfolioId);
	}

	/**
	 * This end-point is used to save a {@link Portfolio} via post request.
	 * 
	 * @param the request body has the {@link Portfolio} body as a json body.
	 * 
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the saved {@link Portfolio}.
	 */
	@PostMapping(value = "/portfolio")
	public ResponseEntity<Portfolio> savePortfolio(@RequestBody Portfolio portfolio) {
		return this.portfolioService.savePortfolio(portfolio);
	}

	/**
	 * This end-point is used to modify an existing {@link Portfolio} corresponding
	 * to a {@link Portfolio}-id via put request.
	 * 
	 * @param the request body has the {@link Portfolio} as a json and as Request
	 *            parameter the Portfolio-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the updated {@link Portfolio}.
	 */
	@PutMapping(value = "/portfolio")
	public ResponseEntity<Portfolio> updateKPIById(@RequestBody Portfolio portfolio,
			@RequestParam(name = "portfolioId") long portfolioId) {
		return this.portfolioService.updatePortfolio(portfolio, portfolioId);
	}

	/**
	 * This end-point is used to delete a {@link Portfolio} having a Portfolio-id
	 * via delete request.
	 * 
	 * @param the request param has the Portfolio-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus}
	 *         204.
	 */
	@DeleteMapping(value = "/deletePortfolio")
	public ResponseEntity<Portfolio> deleteProjectById(@RequestParam(name = "portfolioId") long id) {
		return this.portfolioService.deletePortfolio(id);
	}

}
