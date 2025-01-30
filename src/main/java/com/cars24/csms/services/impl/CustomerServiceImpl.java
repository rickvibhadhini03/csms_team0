package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.CustomerDao;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.req.CreateCustomerReq;
import com.cars24.csms.data.req.GetCustomerReq;
import com.cars24.csms.data.req.UpdateCustomerReq;
import com.cars24.csms.data.resp.CreateCustomerRes;
import com.cars24.csms.data.resp.GetCustomerRes;
import com.cars24.csms.data.resp.UpdateCustomerRes;
import com.cars24.csms.exceptions.DuplicatePhoneException;
import com.cars24.csms.services.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;
    @Override
    @Transactional
    public CreateCustomerRes createCustomer(CreateCustomerReq createCustomerReq) {
        try {
            int CustomerId = customerDao.createCustomer(createCustomerReq);
            CreateCustomerRes response = new CreateCustomerRes();
            //response.setCustomer_id(0);
            response.setName(createCustomerReq.getName());
            response.setPhone(createCustomerReq.getPhone());
            response.setEmail(createCustomerReq.getEmail());
            response.setAddress(createCustomerReq.getAddress());
            return response;
        }
        catch (DataIntegrityViolationException ex) {
            throw new DuplicatePhoneException("Phone number already exists: " + createCustomerReq.getPhone());
        }
    }

    @Override
    public GetCustomerRes getCustomerReq(GetCustomerReq getCustomerReq) {
        return customerDao.getCustomerReq(getCustomerReq);
    }

    @Override
    @Transactional
    public boolean deleteCustomer_phone(String phone) {
        return customerDao.deleteCustomerReq(phone);
    }

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public UpdateCustomerRes updateCustomer(UpdateCustomerReq updateCustomerReq) {
        return customerDao.updateCustomer(updateCustomerReq);
    }


}
