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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.dto.AppointmentDTO;
import com.pms.user.entity.Appointment;
import com.pms.user.service.AppointmentService;

@RestController
@RequestMapping("/user")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("/appointment")
	public List<Appointment> getAllAppointment(){
		return appointmentService.getAllAppointment();
	}
	
	@PostMapping("/appointment")
	public String createAppointment(@RequestBody @Valid AppointmentDTO appointmentDto) {
		boolean flag = appointmentService.saveAppointmentDetails(appointmentDto);
		return flag==true?"Appointment Scheduled Successfully":"Appointment Alredy Scheduled";
	}
	
	@DeleteMapping("/Appointment")
	public String deleteAppointment(@PathVariable long appointmentId) {
		appointmentService.deleteAppointmentByAppointmentId(appointmentId);
		return "Appointment Deleted Successfully";
	}
	
	@PutMapping("/appointment")
	public String modifyAppointment(@RequestBody Appointment appointment) {
		boolean flag = appointmentService.updateAppointmentByAppointmentId(appointment.getAppointmentId(), appointment);
		return flag==true?"Appointment Updated Successfully":"Appointment Doesnot Exists";
	}
	
	@GetMapping("/appointment/{appointmentId}")
	public Appointment getAppointment(@PathVariable long appointmentId) {
		return appointmentService.getAppointmentByAppointmentId(appointmentId);
	}
	
	@GetMapping("/appointment/slot")
	public List<String> getAllAvailableSlot(@RequestParam String date){
		return appointmentService.getAllAvailableSlot(date);
	}

}
