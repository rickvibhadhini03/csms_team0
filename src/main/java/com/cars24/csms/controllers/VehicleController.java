package com.cars24.csms.controllers;


import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.resp.CreateVehicleResponse;
import com.cars24.csms.data.resp.GetVehicleRes;
import com.cars24.csms.services.VehicleServiceManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vehicle")
@Validated
@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleController {

    private final VehicleServiceManagementService vehicleServiceManagementService;

    @PostMapping("/create")
    public ResponseEntity<CreateVehicleResponse> createVehicle(@Valid @RequestBody CreateVehicleReq createVehicleReq) {
        log.info("[createVehicle] createVehicleReq: {}", createVehicleReq);
//        System.out.println("[createVehicle] createVehicleReq: {}"+ createVehicleReq);

        CreateVehicleResponse response = vehicleServiceManagementService.createVehicle(createVehicleReq);

        return ResponseEntity.ok().body(response);
    }

//    public ResponseEntity<>
    @GetMapping("/fetch/{vehicleId}")
    public ResponseEntity<GetVehicleRes> getVehicleDetails(@PathVariable Integer vehicleId) {

        //this should call a method in service layer that returns GetVehicleRes object
        //it should process the passed parameter
        GetVehicleRes response = vehicleServiceManagementService.getVehicle(vehicleId);
        return ResponseEntity.ok().body(response);

    }



//    @DeleteMapping("/delete/{customer_id}")
//    public ResponseEntity<String> deleteVehicle(@PathVariable Integer customer_id) {
//
//        log.info("[deleteVehicle] customer_id {}: " + customer_id);
//        DeleteVehicleRequest deleteVehicleRequest = new DeleteVehicleRequest();
//        deleteVehicleRequest.setCustomer_id(customer_id);
//        vehicleServiceManagementService.deleteVehicle(customer_id);
//        return ResponseEntity.ok().body("Vehicle deleted Successfully");
//    }



}
