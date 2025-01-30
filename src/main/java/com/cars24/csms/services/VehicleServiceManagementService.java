package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.resp.CreateServiceResponse;
import org.springframework.stereotype.Service;

@Service
public interface VehicleServiceManagementService {
    CreateServiceResponse createService(CreateServiceReq createServiceReq);
    void deleteService(Integer id);
CreateServiceResponse getServiceByID(int id);
//    //GetServiceRes getService(GetServiceReq getServiceReq);
//
}
