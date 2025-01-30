package com.cars24.csms.controller;

import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.req.UpdateAppointmentRequest;
import com.cars24.csms.data.resp.CreateAppointmentResponse;
import com.cars24.csms.data.resp.GetAppointmentsResponse;
import com.cars24.csms.services.impl.AppointmentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
@Validated
@Slf4j
public class AppointmentController {

    private final AppointmentServiceImpl appointmentServices;
    @PostMapping("/create")
    public ResponseEntity<CreateAppointmentResponse> createAppointment(@Valid @RequestBody CreateAppointmentRequest createAppointmentRequest) {
        // Create appointment and return the response
        CreateAppointmentResponse response = appointmentServices.createAppointment(createAppointmentRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getAppointments(@PathVariable Integer customerId){
        log.info("Fetching appointments for customer ID: {}", customerId);
        try{
            List<GetAppointmentsResponse> appointments = appointmentServices.getAppointments(customerId);

            //if no appointments are found, return a custom message
            if(appointments.isEmpty()){
                return ResponseEntity.status(HttpStatus.OK)
                        .body(Collections.singletonMap("message", "No appointments found for the customer id: " + customerId));
            }
            return ResponseEntity.ok(appointments);
        } catch (IllegalArgumentException e){
            log.error("[getAppointments] Invalid customer ID: {}", customerId, e);
            return ResponseEntity.badRequest()
                    .body(Collections.singletonMap("message", "Invalid customer id"));
        }catch (Exception e){
            log.error("[getAppointments] Unexpected Error: {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "An unexpected error occurred"));
        }
    }
//    @GetMapping("/by-date/{date}")
//    public ResponseEntity<?> getAppointmentsByDate(@PathVariable String date) {
//        log.info("fetching the details ");
//        try {
//            List<CreateAppointmentResponse> appointments = appointmentServices.getAppointmentsByDate(date);
//
//            // If no appointments found, return a custom message
//            if (appointments.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.OK)  // OK status code instead of 404
//                        .body(Collections.singletonMap("message", "No appointments found for the date: " + date));
//            }
//            return ResponseEntity.ok(appointments);
//
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.badRequest()
//                    .body(Collections.singletonMap("message", "Invalid date format. Expected format: yyyy-MM-dd"));
//        }
//    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<String> updateAppointment(
            @PathVariable int appointmentId,
            @RequestBody UpdateAppointmentRequest updateRequest) {
        try {
            // Call service to update the appointment
            appointmentServices.updateAppointment(appointmentId, updateRequest);
            return ResponseEntity.ok("Appointment with ID " + appointmentId + " has been updated successfully.");
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment with ID " + appointmentId + " not found.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while updating the appointment.");
        }
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int appointmentId) {
        try {
            appointmentServices.deleteAppointment(appointmentId);
            return ResponseEntity.ok("Appointment with ID " + appointmentId + " has been deleted successfully.");
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment with ID " + appointmentId + " not found.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting the appointment.");
        }
    }

    @PatchMapping("/{appointmentId}/deactivate")
    public ResponseEntity<String> deactivateAppointment(@PathVariable int appointmentId) {
        try {
            appointmentServices.deactivateAppointment(appointmentId);
            return ResponseEntity.ok("Appointment with ID " + appointmentId + " has been deactivated successfully.");
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment with ID " + appointmentId + " not found.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deactivating the appointment.");
        }
    }


}

