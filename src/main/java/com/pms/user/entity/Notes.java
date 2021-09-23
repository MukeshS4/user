package com.pms.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Notes {
	
	
	
	@Id
	@Column(name="Notes_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long notesId;
	
	@Column(name = "Receiver_Name",nullable = false)
	private String receiverName;
	
	@Column(name = "Receiver_Designation", length = 10, nullable = false)
	private String receiverDesignation;
	
	@Column(name = "Message", length = 250, nullable = false)
	private String message;
	
	@Column(name = "Date")
	private LocalDateTime dateTime;
	
	@Column(name = "Priority", columnDefinition = "boolean default true")
	private boolean priority = true;

	@ManyToOne
	@JoinColumn(name = "Employee_Id", referencedColumnName = "Employee_Id")
	private HospitalStaff receiverId;

	public HospitalStaff getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(HospitalStaff receiverId) {
		this.receiverId = receiverId;
	}

	public long getNotesId() {
		return notesId;
	}

	public void setNotesId(long notesId) {
		this.notesId = notesId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverDesignation() {
		return receiverDesignation;
	}

	public void setReceiverDesignation(String receiverDesignation) {
		this.receiverDesignation = receiverDesignation;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public Notes(HospitalStaff receiverId, long notesId, String receiverName, String receiverDesignation, String message,
			LocalDateTime dateTime, boolean priority) {
		super();
		this.receiverId = receiverId;
		this.notesId = notesId;
		this.receiverName = receiverName;
		this.receiverDesignation = receiverDesignation;
		this.message = message;
		this.dateTime = dateTime;
		this.priority = priority;
	}

	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}
