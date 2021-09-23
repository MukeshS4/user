package com.pms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.dto.NotesDTO;
import com.pms.user.entity.Notes;
import com.pms.user.service.NotesService;

@RestController
@RequestMapping("/user")
public class NotesController {
	
	@Autowired
	public NotesService notesService;
	
	@GetMapping("/notes")
	public List<Notes> getAllNotes(){
		return notesService.getAllNotes();
	}
	
	@GetMapping("/notes{notesId}")
	public Notes getNotesByNotesId(@PathVariable long notesId) {
		return notesService.getNotesByNotesId(notesId);
	}
	
	@PostMapping("/notes")
	public String getNotes(@RequestBody NotesDTO notes) {
		System.out.println("Notes=="+notes);
		//return "success";
		return notesService.saveNotesDetails(notes);
	}

}
