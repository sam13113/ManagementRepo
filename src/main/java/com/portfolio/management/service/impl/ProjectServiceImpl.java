/**
 * 
 */
package com.portfolio.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.management.entity.Project;
import com.portfolio.management.repository.PortfolioRepository;
import com.portfolio.management.repository.ProjectRepository;
import com.portfolio.management.service.ProjectService;

/**
 * The default implementation for {@link ProjectService}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository projectRepository;
	private PortfolioRepository portfolioRepository;

	/**
	 * All arguments constructor with dependency injected repository objects.
	 */
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository, PortfolioRepository portfolioRepository) {
		this.projectRepository = projectRepository;
		this.portfolioRepository = portfolioRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<List<Project>> getAllProjects() {
		return new ResponseEntity<>(this.projectRepository.findAll(), HttpStatus.FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Project> getProjectById(long projectId) {
		if (projectRepository.findById(projectId).isPresent())
			return new ResponseEntity<>(projectRepository.findById(projectId).get(), HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Project> saveProject(Project project, long PortfolioId) {
		if (portfolioRepository.findById(PortfolioId).isPresent()) {
			project.setPortfolio(portfolioRepository.findById(PortfolioId).get());
			return new ResponseEntity<>(this.projectRepository.saveAndFlush(project), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Project> updateProject(Project project, long projectId) {
		if (projectId == project.getId())
			if (projectRepository.findById(projectId).isPresent()) {
				Project savedProject = projectRepository.findById(projectId).get();
				savedProject.setBusinessWeightage(project.getBusinessWeightage());
				if (project.getDepartment() != null)
					savedProject.setDepartment(project.getDepartment());
				if (project.getDevelopmentMethodology() != null)
					savedProject.setDevelopmentMethodology(project.getDevelopmentMethodology());
				if (project.getProjectDescription() != null)
					savedProject.setProjectDescription(project.getProjectDescription());
				if (project.getProjectName() != null)
					savedProject.setProjectName(project.getProjectName());
				if (project.getManager() != null)
					savedProject.setManager(project.getManager());
				if (project.getOwnerBusiness() != null)
					savedProject.setOwnerBusiness(project.getOwnerBusiness());
				if (project.getOwnerIT() != null)
					savedProject.setOwnerIT(project.getOwnerIT());

				return new ResponseEntity<>(this.projectRepository.saveAndFlush(savedProject), HttpStatus.ACCEPTED);
			}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Project> deleteProject(long projectId) {
		if (projectRepository.findById(projectId).isPresent())
			this.projectRepository.deleteById(projectId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
