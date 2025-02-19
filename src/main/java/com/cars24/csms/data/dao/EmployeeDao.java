package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.CreateEmployeeRequest;
import org.springframework.stereotype.Service;

@Service

public interface EmployeeDao {
    public int createEmployee(CreateEmployeeRequest createEmployeeRequest);
    public int getEmployee(Integer id);
    public void deleteEmployee(Integer id);
    public void updateEmployee(Integer id,CreateEmployeeRequest createEmployeeRequest);
}
