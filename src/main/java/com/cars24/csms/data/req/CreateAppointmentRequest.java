package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.AppointmentStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

//import javax.validation.Valid;
//import javax.validation.constraints.*;

@Valid
@Data     //no need to write getter , setter and toString all methods are automatically added
public class CreateAppointmentRequest {

    //here one annotation of validation then i am supposed to put valid
    @Valid
    @Min(value=1,message="Invalid customer id")
    private int customerId;

    @Valid
    @Min(value=1,message="Invalid vehicle id")
    private int vehicleId;

    @Valid
    @Min(value=1,message="Invalid service id")
    private int serviceId;

//    @NotNull(message = "Appointment date cannot be null")
//    @Future(message = "Appointment date must be in the future")
    @Valid
    @NotBlank
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}",
            message = "Invalid date-time format. Expected format: yyyy-MM-ddTHH:mm"
    )
    private String appointmentDate;

    private AppointmentStatus status;
    //enums help us to make sure that data is only within that options
    //if it comes for email then add @Email, NotNull, NotBlank--automatically check for null values also, @Max(value50)
    //@Pattern for phone number here it should have regexp for regex and validate it
    //@Length(min=3,max=100)
}
