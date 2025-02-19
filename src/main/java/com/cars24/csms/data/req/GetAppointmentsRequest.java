package com.cars24.csms.data.req;
import com.cars24.csms.data.enums.AppointmentStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Valid
@Data
public class GetAppointmentsRequest {

    @Valid
    @Min(value = 1, message = "Invalid Customer ID")
    private int customerId;

    @Valid
    @Min(value = 1, message = "Invalid Vehicle ID")
    private int vehicleId;

    @Valid
    @Min(value = 1, message = "Invalid Service ID")
    private int serviceId;

    @Valid
    @NotBlank
    @Pattern(
            regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",
            message = "Invalid date format. Expected format: yyyy-MM-dd"
    )
    private String appointmentDate;

    @Valid
    private AppointmentStatus status;
}

