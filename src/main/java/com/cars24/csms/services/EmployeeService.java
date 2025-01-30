package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.data.resp.CreateEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest);
    public CreateEmployeeResponse getEmployee(Integer id);
    public void deleteEmployee(Integer id);
}
