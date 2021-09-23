package com.pms.user.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Check;

@Entity
public class Appointment {
	
	@Id
	@Column(name="Appointment_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long appointmentId;
	
	@ManyToOne
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Patient_Id")
	private Patient patient;
	
	@Column(name="Description", length=150, nullable=false)
	private String description;
	
	@Column(name="Date", nullable=false)
	private LocalDate date;
	
	@Column(name="Time", nullable=false)
	private String time;
	
	@ManyToOne
	@JoinColumn(name = "Employee_Id", referencedColumnName = "Employee_Id")
	private HospitalStaff employee;
	
	@Check(constraints="'Scheduled','Cancelled', 'Completed'")
	@Column(name="Status")
	private String status;

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public HospitalStaff getEmployee() {
		return employee;
	}

	public void setEmployee(HospitalStaff employee) {
		this.employee = employee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Appointment(long appointmentId, Patient patient, String description, LocalDate date, String time,
			HospitalStaff employee, String status) {
		super();
		this.appointmentId = appointmentId;
		this.patient = patient;
		this.description = description;
		this.date = date;
		this.time = time;
		this.employee = employee;
		this.status = status;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patient=" + patient + ", description="
				+ description + ", date=" + date + ", time=" + time + ", employee=" + employee + ", status="
				+ status + "]";
	}

}
