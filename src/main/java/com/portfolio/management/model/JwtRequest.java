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
 * A model class representing the JWT request body coming in during a login
 * request.
 * 
 * @author Sarath
 * @since 0.2
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = -1488611822346659043L;

	private String username;
	private String password;
}
