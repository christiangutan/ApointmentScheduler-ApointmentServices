package appointmentscheduler.appointmentservice.infrastructure.repository.jpa;

import appointmentscheduler.appointmentservice.domain.Appointment;
import appointmentscheduler.appointmentservice.domain.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppointmentRepositoryImpl implements AppointmentRepository{

    private final SpringDataAppointmentRepository appointmentJpaRepository;
    private final SpringDataAppointmentRepository serviceJpaRepository;

    @Override
    public List<Appointment> getAppointments() {
        return appointmentJpaRepository
                .findAll()
                .stream()
                .map(AppointmentEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentJpaRepository
                .findById(id)
                .map(AppointmentEntity::toDomain);
    }

    @Override
    public Long createAppointment(Appointment appointment) {
        AppointmentEntity appointmentEntity = AppointmentEntity.fromDomain(appointment);
        appointmentEntity.setService(serviceJpaRepository.getServiceById(appointment.getService().getId()));
        return appointmentJpaRepository.save(appointmentEntity).getId();
    }
}
