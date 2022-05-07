/**
 * 
 */
package com.portfolio.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.management.entity.Portfolio;
import com.portfolio.management.repository.PortfolioRepository;
import com.portfolio.management.service.PortfolioService;

/**
 * The default implementation for {@link PortfolioService}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Service
public class PortfolioServiceImpl implements PortfolioService {

	private PortfolioRepository portfolioRepository;

	/**
	 * All arguments constructor with dependency injected repository objects.
	 */
	@Autowired
	public PortfolioServiceImpl(PortfolioRepository portfolioRepository) {
		this.portfolioRepository = portfolioRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<List<Portfolio>> getAllPortfolios() {
		List<Portfolio> listOfPortfolios = this.portfolioRepository.findAll();
		return new ResponseEntity<>(listOfPortfolios, HttpStatus.FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Portfolio> getPortfolioById(long portfolioId) {
		if (portfolioRepository.findById(portfolioId).isPresent())
			return new ResponseEntity<>(portfolioRepository.findById(portfolioId).get(), HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Portfolio> savePortfolio(Portfolio portfolio) {
		return new ResponseEntity<>(this.portfolioRepository.saveAndFlush(portfolio), HttpStatus.ACCEPTED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Portfolio> updatePortfolio(Portfolio portfolio, long portfolioId) {
		if (portfolioId == portfolio.getId())
			if (portfolioRepository.findById(portfolioId).isPresent()) {
				Portfolio savedPortfolio = this.portfolioRepository.findById(portfolioId).get();
				savedPortfolio.setBusinessWeightage(portfolio.getBusinessWeightage());
				if (portfolio.getPortfolioDescription() != null)
					savedPortfolio.setPortfolioDescription(portfolio.getPortfolioDescription());
				if (portfolio.getPortfolioModel() != null)
					savedPortfolio.setPortfolioModel(portfolio.getPortfolioModel());
				if (portfolio.getPortfolioName() != null)
					savedPortfolio.setPortfolioName(portfolio.getPortfolioName());
				if (portfolio.getSolution() != null)
					savedPortfolio.setSolution(portfolio.getSolution());

				return new ResponseEntity<>(this.portfolioRepository.saveAndFlush(savedPortfolio), HttpStatus.ACCEPTED);
			}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Portfolio> deletePortfolio(long portfolioId) {
		if (portfolioRepository.findById(portfolioId).isPresent())
			this.portfolioRepository.deleteById(portfolioId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
