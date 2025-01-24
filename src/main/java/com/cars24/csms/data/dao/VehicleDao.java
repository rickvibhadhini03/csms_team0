package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.req.CreateVehicleReq;
import org.springframework.stereotype.Service;


@Service
public interface VehicleDao {
    VehicleEntity createVehicle(CreateVehicleReq createVehicleReq);
    VehicleEntity getVehicle(Integer vehicleId);
//    void deleteVehicleById(Integer vehicleId);
}
