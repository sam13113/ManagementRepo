/**
 * 
 */
package com.portfolio.management.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.portfolio.management.entity.Portfolio;
import com.portfolio.management.entity.Project;

/**
 * Service interface for all transactions relating to a {@link Project }.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
public interface ProjectService {

	/**
	 * The service method to get all {@link Project} from the db.
	 * 
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and list of all
	 *         {@link Project} entities.
	 */
	public ResponseEntity<List<Project>> getAllProjects();

	/**
	 * The service method to get a {@link Project} from the db having particular
	 * project-id.
	 * 
	 * @param project-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and saved entity
	 *         {@link Project} having particular project-id or {@link HttpStatus}
	 *         204.
	 */
	public ResponseEntity<Project> getProjectById(long projectId);

	/**
	 * The service method to save a {@link Project} to the db and linking it to
	 * corresponding {@link Portfolio}.
	 * 
	 * @param {@link Project} object and {@link Portfolio}-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and saved entity
	 *         {@link Project} if {@link Portfolio} is found else {@link HttpStatus}
	 *         304 .
	 */
	public ResponseEntity<Project> saveProject(Project project, long PorfolioId);

	/**
	 * The service method to update a {@link Project} in the db.
	 * 
	 * @param {@link Project} object and Project-Id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and updated
	 *         entity {@link Project} or else {@link HttpStatus} 304.
	 */
	public ResponseEntity<Project> updateProject(Project project, long projectId);

	/**
	 * The service method to delete if found, a {@link Project} with given
	 * project-id.
	 * 
	 * @param project-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 204.
	 */
	public ResponseEntity<Project> deleteProject(long projectId);

}
