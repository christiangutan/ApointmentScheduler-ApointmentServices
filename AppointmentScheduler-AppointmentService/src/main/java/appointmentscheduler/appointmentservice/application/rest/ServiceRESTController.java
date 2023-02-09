package appointmentscheduler.appointmentservice.application.rest;

import appointmentscheduler.appointmentservice.domain.Service;
import appointmentscheduler.appointmentservice.domain.service.AppointmentService;
import appointmentscheduler.appointmentservice.domain.service.ServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class ServiceRESTController {
    private final ServiceService serviceService;
    private final AppointmentService appointmentService;

    @GetMapping("/services")
    @ResponseStatus(HttpStatus.OK)
    public List<Service> getServices() {
        log.trace("getServices");
        return serviceService.getServices();
    }

    @GetMapping"/services/{id}"
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        log.trace("getServiceById");
        return serviceService.getServiceById(id);
    }
}
