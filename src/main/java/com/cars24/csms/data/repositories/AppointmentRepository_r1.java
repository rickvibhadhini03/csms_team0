package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppointmentEntities_r1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // even service spring will automatically create objects of these and gives us
public interface AppointmentRepository_r1 extends JpaRepository<AppointmentEntities_r1,Integer> {
//    @Query("SELECT a FROM AppointmentEntities a WHERE DATE(a.appDate) = :date")
//    List<AppointmentEntities> findAppointmentsByDate(@Param("date") LocalDate date);
    @Query("SELECT a FROM AppointmentEntities a WHERE a.isActive = 1")
    List<AppointmentEntities_r1> findAllActiveAppointments();
}
