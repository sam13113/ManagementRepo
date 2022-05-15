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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This entity class for a {@link Country}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "COUNTRY_CODE", unique = true)
	private String countryCode;
	@Column(name = "COUNTRY_NAME", unique = true)
	private String contryName;
	@JsonIgnore
	@OneToMany(mappedBy = "country")
	private Set<OperatingEntity> operatingEntities;
}
