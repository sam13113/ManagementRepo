/**
 * 
 */
package com.portfolio.management.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This entity class for a Portfolio.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Entity
@Table(name = "portfolio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portfolio {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "PORTFOLIO_NAME")
	private String portfolioName;
	@Column(name = "PORTFOLIO_DESCRIPTION")
	private String portfolioDescription;
	@Column(name = "SOLUTION")
	private String solution;
	@Column(name = "PORTFOLIO_MODEL")
	private String portfolioModel;
	@Column(name = "BUSINESS_WEIGHTAGE")
	private int businessWeightage;
	@JsonIgnore
	@OneToMany(mappedBy = "portfolio")
	private Set<Project> projects;
	@ManyToOne
	@JoinColumn(name = "SERVICE_OFFERING_ID")
	private ServiceOffering serviceOffering;

}
