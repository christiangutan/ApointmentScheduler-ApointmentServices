package appointmentScheduler.domain.service;

import appointmentScheduler.domain.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<Service> getServices();

    Optional<Service> getServiceById(Long id);

    Long createService(Service service);


}
