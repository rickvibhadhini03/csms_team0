package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.resp.CreateVehicleResponse;
import com.cars24.csms.data.resp.GetVehicleRes;
import org.springframework.stereotype.Service;


@Service
public interface VehicleServiceManagementService {
    CreateVehicleResponse createVehicle(CreateVehicleReq request);
    GetVehicleRes getVehicle(Integer vehicle_id);
//    DeleteVehicleResponse deleteVehicle(Integer customer_id);
//
//
//    DeleteVehicleResponse deleteVehicle(DeleteVehicleRequest deleteVehicleRequest);
}
