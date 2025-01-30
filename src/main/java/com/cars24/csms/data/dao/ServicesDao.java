package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.DeleteServiceReq;
import com.cars24.csms.data.resp.CreateServiceResponse;
import org.springframework.stereotype.Service;

@Service
public interface ServicesDao {
    int createService(CreateServiceReq createServiceReq);
    void deleteService(Integer id);
CreateServiceResponse getServiceByID(int id);
}
