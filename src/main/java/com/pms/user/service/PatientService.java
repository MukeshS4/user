package com.pms.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.entity.Patient;
import com.pms.user.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getAllPatient(){
		List<Patient> patientList=new ArrayList<>();
		patientRepository.findAll().iterator().forEachRemaining(patient->patientList.add(patient));
		return patientList;
	}
}
