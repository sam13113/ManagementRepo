/**
 * 
 */
package com.portfolio.management.entity;

import java.time.LocalDateTime;

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
 * This entity class for a KPI_DATA associated to a {@link KPI}.
 * 
 * For each individual KPIs there are multiple KPI_DATAs corresponding to
 * different time periods.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Entity
@Table(name = "kpi_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KPIData {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "VALUE")
	private int value;
	@Column(name = "REPORTING_PERIOD")
	private LocalDateTime reportingPeriod;
	@Column(name = "COMMENTS")
	private String comments;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "KPI_ID")
	private KPI kpi;
}
