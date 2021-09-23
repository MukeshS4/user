package com.pms.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pms.user.entity.AppointmentEventAudit;

@Repository
public interface AppointmentEventAuditRepository extends CrudRepository<AppointmentEventAudit, String>{

}
