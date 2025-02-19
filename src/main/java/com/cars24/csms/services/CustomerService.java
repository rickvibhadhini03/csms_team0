package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateCustomerReq;
import com.cars24.csms.data.req.GetCustomerReq;
import com.cars24.csms.data.req.UpdateCustomerReq;
import com.cars24.csms.data.resp.CreateCustomerRes;
import com.cars24.csms.data.resp.GetCustomerRes;
import com.cars24.csms.data.resp.UpdateCustomerRes;


public interface CustomerService {
    public CreateCustomerRes createCustomer(CreateCustomerReq createCustomerReq);
    public GetCustomerRes getCustomerReq(GetCustomerReq getCustomerReq);
    public boolean deleteCustomer_phone(String phone);
    public UpdateCustomerRes updateCustomer(UpdateCustomerReq updateCustomerReq);
    //public LoginReq loginCustomer(LoginRes loginRes);

}
