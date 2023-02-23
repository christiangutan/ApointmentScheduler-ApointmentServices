package appointmentScheduler.application.rest;

import appointmentScheduler.application.request.CreateAppointmentRequest;
import appointmentScheduler.domain.Appointment;
import appointmentScheduler.domain.service.AppointmentService;
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
public class AppointmentRESTController {

    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAppointments() {
        log.trace("findCategories");
        return appointmentService.getAppointments();
    }

    @GetMapping("/appointments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        log.trace("getAppointmentById");
        return appointmentService
                .getAppointmentById(id)
                .map(appointment -> ResponseEntity.ok().body(appointment))
                .orElse(ResponseEntity.notFound()
                .build());
    }

    @PostMapping("/appointments")
    public ResponseEntity<Long> createAppointment(@RequestBody CreateAppointmentRequest createAppointmentRequest) {
        log.trace("createAppointment");
        Long id = appointmentService.createAppointment(createAppointmentRequest.getAppointment());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(uri).body(id);
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Boolean> deleteAppointment(@PathVariable Long id) {
        log.trace("deleteAppointment");

        appointmentService.deleteAppointment(id);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
