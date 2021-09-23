package com.pms.user.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Check;

@Entity
@Table(
uniqueConstraints = { 
        @UniqueConstraint(columnNames = "Employee_Id") })
	public class HospitalStaff {
	

		@Column(nullable=false, length=3)
		private String title;

		@Column(name="First_Name", nullable=false, length=20)
		private String firstName;
		
		@Column(name="Last_Name", nullable=false, length=20)
		private String lastName;
		
		
		@Column(name="Email_Id", nullable=false, length=50)
		@Pattern(regexp="^.+@.+\\..+$")
		private String emailId;
		
		@Column(name="Date_Of_Birth", nullable=false)
		private Date dateOfBirth;
		
		@Check(constraints="'Physician', 'Nurse', 'Admin,")
		@Column(name="Role", nullable=false,length=10)
		private String role;
		
		@Id
		@Column(name="Employee_Id", nullable=false,length=5)
		private String employeeId;
		
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public String getEmailId() {
			return emailId;
		}
		
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		
		public String getRole() {
			return role;
		}
		
		public void setRole(String role) {
			this.role = role;
		}
		
		public String getEmployeeId() {
			return employeeId;
		}
		
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		
		public HospitalStaff(String title, String firstName, String lastName,
				@Pattern(regexp = "^.+@.+\\..+$") String emailId,
				Date dateOfBirth,
				String role, String employeeId) {
			super();
			this.title = title;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailId = emailId;
			this.dateOfBirth = dateOfBirth;
			this.role = role;
			this.employeeId = employeeId;
		}
		
		public HospitalStaff() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public String toString() {
			return "HospitalStaff [title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
					+ emailId + ", dateOfBirth=" + dateOfBirth + ", role=" + role + ", employeeId=" + employeeId + "]";
		}

}
