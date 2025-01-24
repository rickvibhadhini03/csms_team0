package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.VehicleDao;
import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.resp.CreateVehicleResponse;
import com.cars24.csms.data.resp.GetVehicleRes;
import com.cars24.csms.services.VehicleServiceManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VehicleServiceManagementServiceImpl implements VehicleServiceManagementService {


    private final VehicleDao vehicleDao;
    @Override
    public CreateVehicleResponse createVehicle(CreateVehicleReq request) {
        VehicleEntity createdVehicle = vehicleDao.createVehicle(request);

        // Map VehicleEntity to CreateVehicleResponse
        CreateVehicleResponse response = new CreateVehicleResponse();

        response.setVehicle_id(createdVehicle.getVehicle_id());
        response.setCustomer_id(createdVehicle.getCustomer_id());
        response.setLicense_plate(createdVehicle.getLicense_plate());
        response.setModelName(createdVehicle.getModelName());
        response.setMake(createdVehicle.getMake());
        response.setYear(createdVehicle.getYear());
        response.setColor(createdVehicle.getColor());

        return response;
    }

    public GetVehicleRes getVehicle(Integer vehicle_id) {

        //this should call a method in dao where the function should return either entity or a response itself
        VehicleEntity vehicleEntity =vehicleDao.getVehicle(vehicle_id);
        GetVehicleRes response =new GetVehicleRes();
        response.setVehicle_id(vehicleEntity.getVehicle_id());
        response.setCustomer_id(vehicleEntity.getCustomer_id());
        response.setLicense_plate(vehicleEntity.getLicense_plate());
        response.setModelName(vehicleEntity.getModelName());
        response.setMake(vehicleEntity.getMake());
        response.setYear(vehicleEntity.getYear());
        response.setColor(vehicleEntity.getColor());
        return response;
    }

}

//I like git and still have not learnt all the commands
