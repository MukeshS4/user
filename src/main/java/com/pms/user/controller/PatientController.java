package com.pms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.entity.Patient;
import com.pms.user.service.PatientService;

@RestController
@RequestMapping("/user")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping("/patient")
	public List<Patient> getAllPatient(){
		return patientService.getAllPatient();
	}
}
