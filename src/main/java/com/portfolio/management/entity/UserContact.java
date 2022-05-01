/**
 * 
 */
package com.portfolio.management.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sarath
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserContact {
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(name = "user_contact_sequence", sequenceName = "user_contact_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_contact_sequence")
	private Long id;
	
	@Column(name="EMAIL")
	private String email;
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@Column(name = "USER_ID")
	private Long userId;
	

}
