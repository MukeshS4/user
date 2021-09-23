package com.pms.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.Notes;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Long>{

}
