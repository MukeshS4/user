package com.pms.user.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.constant.TimeSlot;
import com.pms.user.dto.AppointmentDTO;
import com.pms.user.entity.Appointment;
import com.pms.user.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	public AppointmentRepository appointmentRepository;
	
	public boolean saveAppointmentDetails(AppointmentDTO appointmentDto) {
	boolean saveFlag = false;
	DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate localDate=LocalDate.parse(appointmentDto.getDate(),df);
	Appointment appointment = new Appointment();
	appointment.setDate(localDate);
	appointment.setDescription(appointmentDto.getDescription());
	appointment.setEmployee(appointmentDto.getEmployee());
	appointment.setPatient(appointmentDto.getPatient());
	appointment.setTime(appointmentDto.getTime());
	appointment.setStatus("SCHEDULED");
	//if (existingAppointment==null) {
		appointmentRepository.save(appointment);
		saveFlag = true;
	//}
	return saveFlag;
	}
	
	public List<Appointment> getAllAppointment(){
		List<Appointment> allAppointment = new ArrayList<>();
		appointmentRepository.findAll().iterator().forEachRemaining(appointment->{
			allAppointment.add(appointment);
		});
		return allAppointment;
	}
	
	public Appointment getAppointmentByAppointmentId(long appointmentId) {
		Optional<Appointment> appointment = null;
		appointment = appointmentRepository.findById(appointmentId);
		return appointment.orElse(null);
	}
	
	public void deleteAppointmentByAppointmentId(long appointmentId) {
		appointmentRepository.deleteById(appointmentId);
	}
	
	public boolean updateAppointmentByAppointmentId(long appointmentId, Appointment appointment) {
		boolean saveFlag = false;
		Appointment existingAppointment = getAppointmentByAppointmentId(appointmentId);
		if(existingAppointment!=null) {
			appointmentRepository.save(appointment);
			saveFlag = true;
		}
		return saveFlag;
	}
	
	public List<String> getAllAvailableSlot(String date){
		List<String> timeSlot=new ArrayList<>();
		Arrays.asList(TimeSlot.values()).stream().forEach(slot->timeSlot.add(slot.getTimeSlot()));
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate=LocalDate.parse(date,df);
		List<String> bookedSlot=appointmentRepository.getBookedSlotByDateAndStatus(localDate,"CANCELLED");
		timeSlot.removeAll(bookedSlot);
		return timeSlot;
	}

}
