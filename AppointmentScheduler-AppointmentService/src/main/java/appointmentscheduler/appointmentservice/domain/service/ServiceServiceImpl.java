package appointmentscheduler.appointmentservice.domain.service;


import appointmentscheduler.appointmentservice.domain.Service;
import appointmentscheduler.appointmentservice.domain.repository.AppointmentRepository;
import appointmentscheduler.appointmentservice.domain.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
