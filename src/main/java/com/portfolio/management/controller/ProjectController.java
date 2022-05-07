/**
 * 
 */
package com.portfolio.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.management.entity.Portfolio;
import com.portfolio.management.entity.Project;
import com.portfolio.management.service.ProjectService;

/**
 * This RestController is responsible for all end-points related to
 * {@link Project} management.
 * 
 * @since V0.1
 * 
 * @author Sarath
 *
 */
@RestController
public class ProjectController {

	private ProjectService projectService;

	/**
	 * Constructor for the {@code ProjectController} with dependency injection.
	 * 
	 * @param {@link ProjectService}
	 */
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	/**
	 * This end-point is used to save {@link Project} via post request.
	 * 
	 * @param the request body has the {@link Project} as a json body and the
	 *            associated {@link Portfolio}-id as Request param.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the saved {@link Project}.
	 */
	@PostMapping(value = "/project")
	public ResponseEntity<Project> saveProject(@RequestBody Project project,
			@RequestParam(name = "portfolioId") long portfolioId) {
		return this.projectService.saveProject(project, portfolioId);
	}

	/**
	 * This end-point is used to fetch a list of {@link Project} via get request.
	 * 
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the list of all {@link Project}.
	 */
	@GetMapping(value = "/getAllProjects")
	public ResponseEntity<List<Project>> getAllProjects() {
		return this.projectService.getAllProjects();
	}

	/**
	 * This end-point is used to get a {@link Project} having a specific project-id
	 * via get request.
	 * 
	 * @param as request param the project-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the {@link Project} if present, else empty response with
	 *         HTTPStatus 204.
	 */
	@GetMapping(value = "/getProject")
	public ResponseEntity<Project> getProjectById(@RequestParam(name = "projectId") long projectId) {
		return this.projectService.getProjectById(projectId);
	}

	/**
	 * This end-point is used to modify an existing {@link Project} via put request.
	 * 
	 * @param the request body has the {@link Project} as a json and as Request
	 *            parameter the project-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the updated {@link Project}.
	 */
	@PutMapping(value = "/project")
	public ResponseEntity<Project> updateProjectById(@RequestBody Project project,
			@RequestParam(name = "projectId") long id) {
		return this.projectService.updateProject(project, id);
	}

	/**
	 * This end-point is used to delete a {@link Project} having a project-id via
	 * delete request.
	 * 
	 * @param the request param has the project-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus}
	 *         204.
	 */
	@DeleteMapping(value = "/deleteProject")
	public ResponseEntity<Project> deleteProjectById(@RequestParam(name = "projectId") long id) {
		return this.projectService.deleteProject(id);
	}
}
