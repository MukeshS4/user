package com.pms.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.entity.HospitalStaff;
import com.pms.user.repository.HospitalstaffRepository;

@Service
public class HospitalstaffService {
	
	@Autowired
	HospitalstaffRepository hospitalstaffRepository;
	
	public boolean saveStaffDetails(HospitalStaff staff) {
		boolean saveFlag=false;
		HospitalStaff existingStaff = getHospitalStaffByEmployeeId(staff.getEmployeeId());
		if(existingStaff==null) {
			hospitalstaffRepository.save(staff);
			saveFlag=true;
		}
		return saveFlag;
	}
	
	public List<HospitalStaff> getAllHospitalStaffByRole(String role)
	{
		List<HospitalStaff> allHospitalStaff = getAllHospitalStaff();
		allHospitalStaff.stream().filter(staff->staff.getRole().equals(role)).collect(Collectors.toList());
		return allHospitalStaff;
	}
	
	public List<HospitalStaff> getAllHospitalStaff(){
		List<HospitalStaff> allHospitalStaff = new ArrayList<>();
		hospitalstaffRepository.findAll().iterator().forEachRemaining(staff->{
			allHospitalStaff.add(staff);
		});
		return allHospitalStaff;
	}
	
	public HospitalStaff getHospitalStaffByEmployeeId(String employeeId) {
		Optional<HospitalStaff> hospitalStaff = null;
		hospitalStaff = hospitalstaffRepository.findById(employeeId);
		return hospitalStaff.orElse(null);
	}
	
	public void deleteHospitalStaffByEmailId(String emailId) {
		hospitalstaffRepository.deleteById(emailId);
	}
	
	public boolean updateHospitalStaffByEmailId(String employeeId, HospitalStaff hospitalStaff) {
		boolean saveFlag=false;
		HospitalStaff existingStaff = getHospitalStaffByEmployeeId(employeeId);
		if(existingStaff!=null) {
			hospitalstaffRepository.save(hospitalStaff);
			saveFlag=true;
		}
		return saveFlag;
	}

}
