package com.cars24.csms.controller;

import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.data.resp.CreateEmployeeResponse;
import com.cars24.csms.services.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
@Validated
@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;
    //CreateEmployeeRequest c1=new CreateEmployeeRequest();
    CreateEmployeeResponse createEmployeeResponse=new CreateEmployeeResponse();


    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        //CreateEmployeeResponse createEmployeeResponse=new CreateEmployeeResponse();
        log.info("[createEmployee] createEmployeeRequest {}", createEmployeeRequest);

        //CreateEmployeeResponse response =
        employeeService.createEmployee(createEmployeeRequest);
        return ResponseEntity.ok().body(createEmployeeResponse);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateEmployeeResponse> getEmployee(@PathVariable Integer id){
        log.info("[getEmployee] createEmployeeRequest {}",id);
        employeeService.getEmployee(id);
        return ResponseEntity.ok().body(createEmployeeResponse);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CreateEmployeeResponse> getEmployee(@PathVariable Integer id) {
//        log.info("[getEmployee] Request received for ID: {}", id);
//        CreateEmployeeResponse response = employeeService.getEmployee(id); // Fetch response from service
//        if (response != null) {
//            return ResponseEntity.ok(response); // Return response if found
//        } else {
//            return ResponseEntity.notFound().build(); // Return 404 if not found
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        log.info("[deleteEmployeeById] Deleting employee with ID {}", id);
        return ResponseEntity.ok("Employee with ID " + id + " deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateEmployeeResponse> updateEmployee(
            @PathVariable Integer id,
            @Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        employeeService.updateEmployee(id,createEmployeeRequest);
        log.info("[updateEmployee] Updating employee with ID: {}", id);
        return ResponseEntity.ok().body(createEmployeeResponse);

    }

}
