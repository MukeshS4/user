package com.pms.user.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.dto.NotesDTO;
import com.pms.user.entity.Notes;
import com.pms.user.repository.NotesRepository;

@Service
public class NotesService {
	
	@Autowired
	private NotesRepository notesRepository;
	
	public String saveNotesDetails(NotesDTO notesDto) {
		if(notesDto.getReceiverId()!=null)
		{
			Notes notes=new Notes();
			notes.setReceiverId(notesDto.getReceiverId());
			notes.setDateTime(LocalDateTime.now());
			notes.setMessage(notesDto.getMessage());
			notes.setReceiverDesignation(notesDto.getReceiverDesignation());
			notes.setReceiverName(notesDto.getReceiverName());
			notesRepository.save(notes);
			return "Notes sent successfully";
		}
		else
			return "Notes cannot be sent";
		
	}
	
	public List<Notes> getAllNotes(){
		List<Notes> allNotes = new ArrayList<>();
		notesRepository.findAll().iterator().forEachRemaining(not->{
			allNotes.add(not);
		});
		return allNotes;
	}
	
	public Notes getNotesByNotesId(long notesId) {
		Optional<Notes> notes = null;
		notes = notesRepository.findById(notesId);
		return notes.orElse(null);
	}

}
