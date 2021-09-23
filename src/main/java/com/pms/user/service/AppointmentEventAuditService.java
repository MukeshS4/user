package com.pms.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.entity.AppointmentEventAudit;
import com.pms.user.repository.AppointmentEventAuditRepository;

@Service
public class AppointmentEventAuditService {
	
	@Autowired
	AppointmentEventAuditRepository appointmentEventAuditRepository;
	
	public List<AppointmentEventAudit> getAllAppointmentEventAudit(){
		List<AppointmentEventAudit> allAppointmentEventAudits = new ArrayList<>();
		appointmentEventAuditRepository.findAll().iterator().forEachRemaining(audit->{
			allAppointmentEventAudits.add(audit);
		});
		return allAppointmentEventAudits;
	}
	
	public AppointmentEventAudit getAppointmentEventAuditByAuditId(String auditId) {
		Optional<AppointmentEventAudit> appointmentEventAudit = null;
		appointmentEventAudit = appointmentEventAuditRepository.findById(auditId);
		return appointmentEventAudit.orElse(null);
	}

}
