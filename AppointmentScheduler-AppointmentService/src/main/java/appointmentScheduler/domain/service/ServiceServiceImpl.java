package appointmentScheduler.domain.service;


import appointmentScheduler.domain.Service;
import appointmentScheduler.domain.repository.AppointmentRepository;
import appointmentScheduler.domain.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService{

    private final AppointmentRepository appointmentRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public List<Service> getServices() {
        return serviceRepository.getServices();
    }

    @Override
    public Optional<Service> getServiceById(Long id) {
        return serviceRepository.getServiceById(id);
    }

    @Override
    public Long createService(Service service) {
        return serviceRepository.createService(service);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteService(id);
    }
}
