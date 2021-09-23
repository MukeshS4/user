package com.pms.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.HospitalStaff;

@Repository
public interface HospitalstaffRepository extends CrudRepository<HospitalStaff, String> {


}
