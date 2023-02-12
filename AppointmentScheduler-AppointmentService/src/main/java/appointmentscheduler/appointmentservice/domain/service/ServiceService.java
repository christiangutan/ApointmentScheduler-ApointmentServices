package appointmentscheduler.appointmentservice.domain.service;

import appointmentscheduler.appointmentservice.domain.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<Service> getServices();

    Optional<Service> getServiceById(Long id);

    Long createService(Service service);


}
