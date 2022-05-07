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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This entity class for a ServiceOffering associated to a
 * {@link OperationalEntity}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Entity
@Table(name = "service_offering")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceOffering {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "SERVICE_NAME")
	private String serviceName;
	@Column(name = "SERVICE_DESCRIPTION")
	private String servicedescription;
	@Column(name = "BUSINESS_WEIGHTAGE")
	private int businessWeightage;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "OPERATING_ENTITY_ID")
	private OperatingEntity operatingEntity;
}
