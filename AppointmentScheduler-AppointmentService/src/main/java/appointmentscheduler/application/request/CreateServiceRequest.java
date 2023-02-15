package appointmentScheduler.application.request;

import appointmentScheduler.domain.Service;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import javax.validation.constraints.NotNull;

public class CreateServiceRequest {

    @Getter
    @NotNull
    private final Service service;

    @JsonCreator
    public CreateServiceRequest(@JsonProperty("service") @NotNull final Service service) {
        this.service = service;
    }
}
