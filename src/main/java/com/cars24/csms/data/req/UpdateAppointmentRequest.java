package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateAppointmentRequest {
    @Valid
    @NotBlank
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}",
            message = "Invalid date-time format. Expected format: yyyy-MM-dd HH:mm"
    )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentDate;


    private AppointmentStatus status;
}
