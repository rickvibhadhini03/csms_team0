package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.EmployeeDao;
import com.cars24.csms.data.entities.EmployeeEntity;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.repositories.EmployeeRepository;
import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.exceptions.UserServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeDaoImpl implements EmployeeDao {

    //@Autowired
    private final EmployeeRepository employeeRepository;
    EmployeeEntity employeeEntity = new EmployeeEntity();
    private final AppUserRepository appUserRepository;

    public int createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        //EmployeeEntity employeeEntity = new EmployeeEntity();
        boolean userExists = appUserRepository.existsByName(createEmployeeRequest.getName());
        if (!userExists) {
            throw new UserServiceException("User with name '" + createEmployeeRequest.getName() + "' does not exist.");
        }

        employeeEntity.setId(0);

        employeeEntity.setName(createEmployeeRequest.getName());
        employeeEntity.setPhone(createEmployeeRequest.getPhone());
        employeeEntity.setEmail(createEmployeeRequest.getEmail());
        employeeEntity.setRole(createEmployeeRequest.getRole());
        employeeEntity.setSalary(createEmployeeRequest.getSalary());

        employeeRepository.save(employeeEntity);
        log.info("[createEmployee]",createEmployeeRequest);
        return 0;

    }

    public int getEmployee(Integer id){

        log.info("[getEmployee] Retrieved employee details: {}", id);
        employeeRepository.findById(id);
        return id;
    }

    public void deleteEmployee(Integer id){

        employeeRepository.deleteById(id);

    }

    public void updateEmployee(Integer id,CreateEmployeeRequest createEmployeeRequest){
        //EmployeeEntity employeeEntity=employeeRepository.findById(id)
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        employeeEntity.setName(createEmployeeRequest.getName());
        employeeEntity.setPhone(createEmployeeRequest.getPhone());
        employeeEntity.setEmail(createEmployeeRequest.getEmail());
        employeeEntity.setRole(createEmployeeRequest.getRole());
        employeeEntity.setSalary(createEmployeeRequest.getSalary());

        // Save the updated employee

        employeeRepository.save(employeeEntity);

    }
}

