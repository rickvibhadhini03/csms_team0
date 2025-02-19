package com.cars24.csms.data.dao.impl;
import com.cars24.csms.data.req.UpdateCustomerReq;
import com.cars24.csms.data.resp.UpdateCustomerRes;
import com.cars24.csms.exceptions.CustomerNotFoundException;
import jakarta.persistence.EntityManager;
import com.cars24.csms.data.dao.CustomerDao;
import com.cars24.csms.data.entites.CustomerEntity;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.req.CreateCustomerReq;
import com.cars24.csms.data.req.GetCustomerReq;
import com.cars24.csms.data.resp.GetCustomerRes;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
@RequiredArgsConstructor
public class CustomerDaoImpl implements CustomerDao  {
    private JdbcTemplate jdbcTemplate;
    private final CustomerRepository customerRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public int createCustomer(CreateCustomerReq createCustomerReq) {
        CustomerEntity customerEntity = new CustomerEntity();

        //customerEntity.setCustomer_id(0);
        customerEntity.setName(createCustomerReq.getName());
        customerEntity.setPhone(createCustomerReq.getPhone());
        customerEntity.setEmail(createCustomerReq.getEmail());
        customerEntity.setAddress(createCustomerReq.getAddress());

        customerRepository.save(customerEntity);
        return 0;
    }

    public GetCustomerRes getCustomerReq(GetCustomerReq getCustomerReq) {
        // Get phone number from request object
        String phone = getCustomerReq.getPhone();

        // Use the repository method to fetch customer by phone
        Optional<CustomerEntity> customerOpt = customerRepository.getByPhone(phone);

        // If no customer found, throw custom exception
        if (customerOpt.isEmpty()) {
            throw new CustomerNotFoundException("No customer found with phone: " + phone);
        }

        // Map customer entity to response
        CustomerEntity customer = customerOpt.get();
        GetCustomerRes response = new GetCustomerRes();
        response.setPhone(customer.getPhone());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setAddress(customer.getAddress());

        return response;
    }

    @Override
    public boolean deleteCustomerReq(String phone) {
        // Check if the customer exists by phone number first
        if (customerRepository.getByPhone(phone).isPresent()) {
            customerRepository.deleteByPhone(phone);  // Delete customer by phone number
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public UpdateCustomerRes updateCustomer(UpdateCustomerReq updateCustomerReq) {
        String phone = updateCustomerReq.getPhone();

        // Fetch the customer by phone
        CustomerEntity customer = customerRepository.getByPhone(phone)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with phone " + phone + " not found."));

        // Update customer details
        if (updateCustomerReq.getName() != null) {
            customer.setName(updateCustomerReq.getName());
        }
        if (updateCustomerReq.getEmail() != null) {
            customer.setEmail(updateCustomerReq.getEmail());
        }
        if (updateCustomerReq.getAddress() != null) {
            customer.setAddress(updateCustomerReq.getAddress());
        }

        // Save the updated customer back to the database
        customerRepository.save(customer);

        // Prepare the response
        UpdateCustomerRes response = new UpdateCustomerRes();
        response.setPhone(customer.getPhone());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setAddress(customer.getAddress());

        return response;
    }

}
