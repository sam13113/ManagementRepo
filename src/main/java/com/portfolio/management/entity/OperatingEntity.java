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
 * This entity class for a OperationalEntity associated to a {@link Country}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Entity
@Table(name = "operating_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperatingEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "ENTITY_NAME")
	private String entityName;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;
}
