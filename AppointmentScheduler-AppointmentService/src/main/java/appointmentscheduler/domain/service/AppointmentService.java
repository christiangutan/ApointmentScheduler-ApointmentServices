package appointmentScheduler.domain.service;

import appointmentScheduler.domain.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> getAppointments();

    Optional<Appointment> getAppointmentById(Long id);

    Long createAppointment(Appointment appointment);
}
