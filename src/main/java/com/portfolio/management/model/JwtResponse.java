/**
 * 
 */
package com.portfolio.management.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A model class representing the JWT response body of a login request.
 * 
 * @author Sarath
 * @since 0.2
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8965780775586023786L;
	private String jwtToken;

}
