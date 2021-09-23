package com.pms.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,String> {

}
