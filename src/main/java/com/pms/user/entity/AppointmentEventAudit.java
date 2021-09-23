package com.pms.user.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class AppointmentEventAudit {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="audit_id")
	private String auditId;
	
	@Column(name="Date", nullable=false)
	private Date date;
	
	@Column(name="Time", nullable=false)
	private Time time;
	
	@ManyToOne
	@JoinColumn(name = "Employee_Id", referencedColumnName = "Employee_Id")
	private HospitalStaff employeeId;
	
	@Column(name="Reason", length=150, nullable=false)
	private String reason;
	
	@ManyToOne
	@JoinColumn(name="appointment_id")
	private Appointment appointmentId;

}
