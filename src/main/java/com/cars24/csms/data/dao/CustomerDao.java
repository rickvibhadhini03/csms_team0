package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.CreateCustomerReq;
import com.cars24.csms.data.req.GetCustomerReq;
import com.cars24.csms.data.req.UpdateCustomerReq;
import com.cars24.csms.data.resp.GetCustomerRes;
import com.cars24.csms.data.resp.UpdateCustomerRes;
import org.springframework.stereotype.Service;

@Service
public interface CustomerDao  {
    public int createCustomer(CreateCustomerReq createCustomerReq);
    public GetCustomerRes getCustomerReq(GetCustomerReq getCustomerReq);
    public boolean deleteCustomerReq(String phone);
    public UpdateCustomerRes updateCustomer(UpdateCustomerReq updateCustomerReq);

}
