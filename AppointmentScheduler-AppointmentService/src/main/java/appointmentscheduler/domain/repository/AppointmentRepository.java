package appointmentScheduler.domain.repository;

import appointmentScheduler.domain.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
    List<Appointment> getAppointments();

    Optional<Appointment> getAppointmentById(Long id);

    Long createAppointment(Appointment appointment);
}
