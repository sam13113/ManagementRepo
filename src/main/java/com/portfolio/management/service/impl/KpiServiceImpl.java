/**
 * 
 */
package com.portfolio.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.management.entity.KPI;
import com.portfolio.management.entity.KPIData;
import com.portfolio.management.repository.KPIDataRepository;
import com.portfolio.management.repository.KPIRepository;
import com.portfolio.management.repository.ProjectRepository;
import com.portfolio.management.service.KPIService;

/**
 * The default implementation for {@link KPIService}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */
@Service
public class KpiServiceImpl implements KPIService {

	private KPIRepository kpiRepository;
	private KPIDataRepository kpiDataRepository;
	private ProjectRepository projectRepository;

	/**
	 * All arguments constructor with dependency injected repository objects.
	 */
	@Autowired
	public KpiServiceImpl(KPIRepository kpiRepository, KPIDataRepository kpiDataRepository,
			ProjectRepository projectRepository) {
		this.kpiRepository = kpiRepository;
		this.kpiDataRepository = kpiDataRepository;
		this.projectRepository = projectRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<List<KPI>> getAllKPIsForProjectId(long projectId) {
		if (projectRepository.findById(projectId).isPresent()) {
			List<KPI> listOfKpis = this.kpiRepository.findAllByProjectId(projectId);
			return new ResponseEntity<>(listOfKpis, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<KPI> getKpiById(long kpiId) {
		if (kpiRepository.findById(kpiId).isPresent())
			return new ResponseEntity<>(kpiRepository.findById(kpiId).get(), HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<KPI> saveKPI(KPI kpi, long projectId) {
		if (projectRepository.findById(projectId).isPresent()) {
			kpi.setProject(projectRepository.findById(projectId).get());
			return new ResponseEntity<>(this.kpiRepository.saveAndFlush(kpi), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<KPI> updateKPI(KPI kpi, long kpiId) {
		if (kpiId == kpi.getId())
			if (kpiRepository.findById(kpiId).isPresent()) {
				KPI savedKpi = this.kpiRepository.findById(kpiId).get();
				savedKpi.setBusinessWeightage(kpi.getBusinessWeightage());
				savedKpi.setThresholdMax(kpi.getThresholdMax());
				savedKpi.setThresholdMin(kpi.getThresholdMin());
				if (kpi.getKpiDescription() != null)
					savedKpi.setKpiDescription(kpi.getKpiDescription());
				if (kpi.getKpiName() != null)
					savedKpi.setKpiName(kpi.getKpiName());
				if (kpi.getProject() != null)
					savedKpi.setProject(kpi.getProject());

				return new ResponseEntity<>(this.kpiRepository.saveAndFlush(savedKpi), HttpStatus.ACCEPTED);
			}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<KPI> deleteKPI(long kpiId) {
		if (kpiRepository.findById(kpiId).isPresent())
			this.kpiRepository.deleteById(kpiId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<List<KPIData>> getAllKPIDataforKpiId(long kpiId) {
		if (kpiRepository.findById(kpiId).isPresent()) {
			List<KPIData> listOfKpiData = this.kpiDataRepository.findAllByKpiId(kpiId);
			return new ResponseEntity<>(listOfKpiData, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<KPIData> getKpiDataById(long kpiDataId) {
		if (kpiDataRepository.findById(kpiDataId).isPresent())
			return new ResponseEntity<>(kpiDataRepository.findById(kpiDataId).get(), HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<KPIData> saveKpiData(KPIData KPIData, long kpiId) {
		if (this.kpiRepository.findById(kpiId).isPresent()) {
			KPIData.setKpi(this.kpiRepository.findById(kpiId).get());
			return new ResponseEntity<>(this.kpiDataRepository.saveAndFlush(KPIData), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<KPIData> updateKPIData(KPIData kpiData, long kpiDataId) {
		if (kpiDataId == kpiData.getId())
			if (this.kpiDataRepository.findById(kpiDataId).isPresent()) {
				KPIData savedKPIData = this.kpiDataRepository.findById(kpiDataId).get();
				if (kpiData.getKpi() != null)
					savedKPIData.setKpi(kpiData.getKpi());
				if (kpiData.getComments() != null)
					savedKPIData.setComments(kpiData.getComments());
				if (kpiData.getReportingPeriod() != null)
					savedKPIData.setReportingPeriod(kpiData.getReportingPeriod());
				savedKPIData.setValue(kpiData.getValue());

				return new ResponseEntity<>(this.kpiDataRepository.saveAndFlush(savedKPIData), HttpStatus.ACCEPTED);
			}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<KPIData> deleteKPIData(long kpiDataId) {
		if (kpiDataRepository.findById(kpiDataId).isPresent())
			this.kpiDataRepository.deleteById(kpiDataId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
