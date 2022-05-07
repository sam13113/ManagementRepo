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

import com.portfolio.management.entity.KPI;
import com.portfolio.management.entity.KPIData;
import com.portfolio.management.entity.Project;
import com.portfolio.management.service.KPIService;

/**
 * This RestController is responsible for all end-points related to {@link KPI}
 * and {@link KPIData} management
 * 
 * @since V0.1
 * 
 * @author Sarath
 *
 */
@RestController
public class KPIController {

	private KPIService kpiService;

	/**
	 * Constructor for the {@code KPIController} with dependency injection.
	 * 
	 * @param {@link KPIService}
	 */
	@Autowired
	public KPIController(KPIService kpiService) {
		this.kpiService = kpiService;
	}

	/**
	 * This end-point is used to get all {@link KPI}s having a specific project-id
	 * via get request.
	 * 
	 * @param as request param the project-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the list of {@link KPI} if present, else empty response with
	 *         HTTPStatus 204.
	 */
	@GetMapping(value = "/getAllKPI")
	public ResponseEntity<List<KPI>> getAllKPIsByProjectId(@RequestParam(name = "projectId") long projectId) {
		return this.kpiService.getAllKPIsForProjectId(projectId);
	}

	/**
	 * This end-point is used to get a {@link KPI} having a specific KPI-id via get
	 * request.
	 * 
	 * @param as request param the KPI-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the {@link KPI} if present, else empty response with
	 *         HTTPStatus 204.
	 */
	@GetMapping(value = "/getKPI")
	public ResponseEntity<KPI> getKPIById(@RequestParam(name = "kpiId") long kpiId) {
		return this.kpiService.getKpiById(kpiId);
	}

	/**
	 * This end-point is used to save a {@link KPI} via post request corresponding
	 * to a specific project-id.
	 * 
	 * @param the request body has the {@link KPI} body as a json body and as
	 *            request parameter {@link Project}-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the saved {@link KPI}.
	 */
	@PostMapping(value = "/kpi")
	public ResponseEntity<KPI> saveKPIforProjectId(@RequestBody KPI kpi,
			@RequestParam(name = "projectId") long projectId) {
		return this.kpiService.saveKPI(kpi, projectId);
	}

	/**
	 * This end-point is used to modify an existing {@link KPI} corresponding to a
	 * {@link KPI}-id via put request.
	 * 
	 * @param the request body has the {@link KPI} as a json and as Request
	 *            parameter the KPI-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the updated {@link KPI}.
	 */
	@PutMapping(value = "/kpi")
	public ResponseEntity<KPI> updateKPIById(@RequestBody KPI kpi, @RequestParam(name = "kpiId") long kpiId) {
		return this.kpiService.updateKPI(kpi, kpiId);
	}

	/**
	 * This end-point is used to delete a {@link KPI} having a KPI-id via delete
	 * request.
	 * 
	 * @param the request param has the KPI-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus}
	 *         204.
	 */
	@DeleteMapping(value = "/deleteKPI")
	public ResponseEntity<KPI> deleteProjectById(@RequestParam(name = "kpiId") long id) {
		return this.kpiService.deleteKPI(id);
	}

	/**
	 * This end-point is used to get all {@link KPIData}s having a specific KPI-id
	 * via get request.
	 * 
	 * @param as request param the KPI-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the list of {@link KPIData} if present, else empty response
	 *         with HTTPStatus 204.
	 */
	@GetMapping(value = "/getAllKPIData")
	public ResponseEntity<List<KPIData>> getAllKPIDatasByKPIId(@RequestParam(name = "kpiId") long kpiId) {
		return this.kpiService.getAllKPIDataforKpiId(kpiId);
	}

	/**
	 * This end-point is used to get a {@link KPIData} having a specific KPI-id via
	 * get request.
	 * 
	 * @param as request param the project-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the {@link KPI} if present, else empty response with
	 *         HTTPStatus 204.
	 */
	@GetMapping(value = "/getKPIData")
	public ResponseEntity<KPIData> getKPIDataById(@RequestParam(name = "kpiDataId") long kpiDataId) {
		return this.kpiService.getKpiDataById(kpiDataId);
	}

	/**
	 * This end-point is used to save a {@link KPIData} via post request
	 * corresponding to a specific KPI-id.
	 * 
	 * @param the request body has the {@link KPIData} body as a json body and as
	 *            request parameter {@link KPI}-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the saved {@link KPIData}.
	 */
	@PostMapping(value = "/kpiData")
	public ResponseEntity<KPIData> saveKPIDataforKpiId(@RequestBody KPIData kpiData,
			@RequestParam(name = "kpiId") long kpiId) {
		return this.kpiService.saveKpiData(kpiData, kpiId);
	}

	/**
	 * This end-point is used to modify an existing {@link KPIData} corresponding to
	 * a {@link KPIData}-id via put request.
	 * 
	 * @param the request body has the {@link KPIData} as a json and as Request
	 *            parameter the KPIData-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the updated {@link KPIData}.
	 */
	@PutMapping(value = "/kpiData")
	public ResponseEntity<KPIData> updateKPIDataById(@RequestBody KPIData kpiData,
			@RequestParam(name = "kpiDataId") long kpiDataId) {
		return this.kpiService.updateKPIData(kpiData, kpiDataId);
	}

	/**
	 * This end-point is used to delete a {@link KPIData} having a KPIData-id via
	 * delete request.
	 * 
	 * @param the request param has the KPIData-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus}
	 *         204.
	 */
	@DeleteMapping(value = "/deleteKPIData")
	public ResponseEntity<KPIData> deleteKPIDataById(@RequestParam(name = "kpiDataId") long kpiDataId) {
		return this.kpiService.deleteKPIData(kpiDataId);
	}
}
