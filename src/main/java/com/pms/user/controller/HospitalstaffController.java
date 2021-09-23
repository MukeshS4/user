package com.pms.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.entity.HospitalStaff;
import com.pms.user.service.HospitalstaffService;

@RestController
@RequestMapping("/user")
public class HospitalstaffController {
	
	@Autowired
	private HospitalstaffService hospitalStaffService;
	
	@GetMapping("/staff")
	public List<HospitalStaff> getAllHospitalStaff() {
		return hospitalStaffService.getAllHospitalStaff();
	}
	
	@GetMapping("/staff/role/{role}")
	public List<HospitalStaff> getAllPhysician(@PathVariable String role) {
		return hospitalStaffService.getAllHospitalStaffByRole(role);
	}
	
	@PostMapping("/staff")
	public String createStaff(@RequestBody @Valid HospitalStaff hospitalStaff) {
		boolean flag=hospitalStaffService.saveStaffDetails(hospitalStaff);
		return flag==true?"User Created Successfully":"User already exists";
	}
	
	@DeleteMapping("/staff/{emailId}")
	public String deleteStaff(@PathVariable String emailId) {
		hospitalStaffService.deleteHospitalStaffByEmailId(emailId);
		return "User deleted successfully";
	}
	
	@GetMapping("/staff/{emailId}")
	public HospitalStaff getStaff(@PathVariable String employeeId) {
		return hospitalStaffService.getHospitalStaffByEmployeeId(employeeId);
	}
	
	@PutMapping("/staff")
	public String updateStaff(@RequestBody HospitalStaff hospitalStaff) {
		boolean flag = hospitalStaffService.updateHospitalStaffByEmailId(hospitalStaff.getEmployeeId(), hospitalStaff);
		return flag==true?"User updated successfully":"user doesnot exists";
	
	
	}
	
}
