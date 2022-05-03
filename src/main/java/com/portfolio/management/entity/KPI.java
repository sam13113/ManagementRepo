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
 * This entity class for a KPI associated to a {@link Project}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Entity
@Table(name = "kpi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KPI {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "KPI_NAME")
	private String kpiName;
	@Column(name = "KPI_DESCRIPTION")
	private String kpiDescription;
	@Column(name = "THRESHOLD_MAX")
	private int thresholdMax;
	@Column(name = "THRESHOLD_MIN")
	private int thresholdMin;
	@Column(name = "BUSINESS_WEIGHTAGE")
	private int businessWeightage;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

}
