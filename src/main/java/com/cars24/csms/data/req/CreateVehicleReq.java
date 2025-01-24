package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Valid
@Data
public class CreateVehicleReq {



    @Valid
    @Min(value =1, message = "Invalid Customer Id")
    private int customer_id;

    @Valid
    @NotNull
    @Size(min=6, max=10)
    private String license_plate;

    @Valid
    @NotNull
    private String modelName;

    @Valid
    @NotNull
    private String make;

    @Valid
    @NotNull
    private int year;

    @Valid
    @NotNull(message = "Invalid")
    private String color;

}
