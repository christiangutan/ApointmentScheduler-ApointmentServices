package appointmentScheduler.application.request;

import appointmentScheduler.domain.Appointment;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import javax.validation.constraints.NotNull;

public class CreateAppointmentRequest {
    @Getter
    @NotNull
    private final Appointment appointment;

    @JsonCreator
    public CreateAppointmentRequest(@JsonProperty("appointment") @NotNull final Appointment appointment) {
        this.appointment = appointment;
    }
}
