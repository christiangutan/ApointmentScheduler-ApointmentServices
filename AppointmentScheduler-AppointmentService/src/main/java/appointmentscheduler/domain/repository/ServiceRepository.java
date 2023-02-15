package appointmentScheduler.domain.repository;

import appointmentScheduler.domain.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    List<Service> getServices();
    Optional<Service> getServiceById(Long id);
    Long createService(Service service);

}
