package com.pms.user.dto;

import com.pms.user.entity.HospitalStaff;
import com.pms.user.entity.Patient;

public class AppointmentDTO {

	private HospitalStaff employee;
	private String date;
	private String time;
	private Patient patient;
	private String description;
	public HospitalStaff getEmployee() {
		return employee;
	}
	public void setEmployee(HospitalStaff employee) {
		this.employee = employee;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
