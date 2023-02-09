package appointmentscheduler.appointmentservice.domain.service;

import appointmentscheduler.appointmentservice.domain.Appointment;
import appointmentscheduler.appointmentservice.domain.Service;
import appointmentscheduler.appointmentservice.domain.repository.AppointmentRepository;
import appointmentscheduler.appointmentservice.domain.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@org.springframework.stereotype.Service
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepository.getAppointments();
    }

    @Override
    public Long createAppointment(Appointment appointment) {
        Long id = null;
        Optional<Service> optService = serviceRepository.getServiceById(appointment.getService().getId());

        if(optService.isPresent()) {
            appointment.setService(optService.get());
            id = appointmentRepository.createAppointment(appointment);

            Optional<Appointment> optShow = appointmentRepository.getAppointmentById(id);
        }else{
            log.error("The appointment with Is: " + id + " has not created because the service with Id: " + appointment.getService().getId() + " does not exist.");
        }

        return id;
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.getAppointmentById(id);

    }
}
