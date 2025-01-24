package com.cars24.csms.data.resp;
import lombok.Data;

@Data
public class CreateVehicleResponse {

    private int vehicle_id;

    private int customer_id;

    private String license_plate;

    private String modelName;

    private String make;

    private int year;

    private String color;
}
