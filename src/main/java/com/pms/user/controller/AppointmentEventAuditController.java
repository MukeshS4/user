package com.pms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.entity.AppointmentEventAudit;
import com.pms.user.service.AppointmentEventAuditService;

@RestController
public class AppointmentEventAuditController {
	
	@Autowired
	public AppointmentEventAuditService appointmentEventAuditService;
	
	@GetMapping("/audit")
	public List<AppointmentEventAudit> getAllAppointmentEventAudit(){
		return appointmentEventAuditService.getAllAppointmentEventAudit();
	}
	
	@GetMapping("/audit/{auditId}")
	public AppointmentEventAudit getAudit(@PathVariable String auditId) {
		return appointmentEventAuditService.getAppointmentEventAuditByAuditId(auditId);
	}

}
