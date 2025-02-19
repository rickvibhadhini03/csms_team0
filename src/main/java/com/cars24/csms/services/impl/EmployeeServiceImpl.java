package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.EmployeeDaoImpl;
import com.cars24.csms.data.entities.EmployeeEntity;
import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.data.resp.CreateEmployeeResponse;
import com.cars24.csms.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    //@Autowired

    private final EmployeeDaoImpl employeeDao;

//    @Autowired
//    public EmployeeServiceImpl(EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }

    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) {

        employeeDao.createEmployee(createEmployeeRequest);
        log.info("[createEmployee]",createEmployeeRequest);
        return null;
    }

    public CreateEmployeeResponse getEmployee(Integer id) {

        employeeDao.getEmployee(id);
        //EmployeeEntity employeeEntity = employeeDao.getEmployee(id);
        log.info("[getEmployee] Retrieved employee details: {}", id);
        return null;
    }

    public void deleteEmployee(Integer id) {

        employeeDao.deleteEmployee(id);
        log.info("[deleteEmployee]",id);

    }

    public CreateEmployeeResponse updateEmployee(Integer id, CreateEmployeeRequest createEmployeeRequest) {

        employeeDao.updateEmployee(id,createEmployeeRequest);
        log.info("[updateEmployee] Employee updated: {}",createEmployeeRequest);
        return null;
    }

}

