package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Integer> {
    //boolean existByAppointmentId(int appointmentId);

}
