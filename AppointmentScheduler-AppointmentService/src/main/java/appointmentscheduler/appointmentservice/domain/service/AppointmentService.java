package appointmentscheduler.appointmentservice.domain.service;

import appointmentscheduler.appointmentservice.domain.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> getAppointments();

    Long createAppointment(Appointment appointment);

    Optional<Appointment> getAppointmentById(Long id);
}
