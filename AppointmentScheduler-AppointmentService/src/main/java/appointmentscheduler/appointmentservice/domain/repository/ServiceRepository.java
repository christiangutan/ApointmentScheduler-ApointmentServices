package appointmentscheduler.appointmentservice.domain.repository;

import appointmentscheduler.appointmentservice.domain.Appointment;
import appointmentscheduler.appointmentservice.domain.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    List<Service> getServices();
    Optional<Service> getServiceById(Long id);

}
