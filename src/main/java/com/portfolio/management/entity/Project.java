/**
 * 
 */
package com.portfolio.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This entity class a Project in the the organization.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "PRJ_NAME")
	private String projectName;
	@Column(name = "PRJ_DESCRIPTION")
	private String projectDescription;
	@Column(name = "DEPARTMENT")
	private String department;
	@Column(name = "BUSINESS_WEIGHTAGE")
	private int businessWeightage;
	@Column(name = "DEVELOPMENT_METHODOLOGY")
	private String developmentMethodology;
	@OneToOne(optional = true)
	@JoinColumn(name = "SERVICE_OWNER_IT_ID")
	private User ownerIT;
	@OneToOne(optional = true)
	@JoinColumn(name = "SERVICE_OWNER_BUSINESS_ID")
	private User ownerBusiness;
	@OneToOne(optional = true)
	@JoinColumn(name = "SERVICE_MANAGER_ID")
	private User manager;

}
