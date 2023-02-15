package appointmentScheduler.application.rest;

import appointmentScheduler.application.request.CreateServiceRequest;
import appointmentScheduler.domain.Service;
import appointmentScheduler.domain.service.AppointmentService;
import appointmentScheduler.domain.service.ServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/services/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        log.trace("getServiceById");
        return serviceService
                .getServiceById(id)
                .map(service -> ResponseEntity.ok().body(service))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/services")
    public ResponseEntity<Long> createAppointment(@RequestBody CreateServiceRequest createServiceRequest) {

        log.trace("createService");
        Long id = serviceService.createService(createServiceRequest.getService());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(uri).body(id);
    }
}
