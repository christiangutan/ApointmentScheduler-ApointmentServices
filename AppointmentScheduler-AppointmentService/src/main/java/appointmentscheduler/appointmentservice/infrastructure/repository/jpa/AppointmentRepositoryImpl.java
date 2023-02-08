package appointmentscheduler.appointmentservice.infrastructure.repository.jpa;

import appointmentscheduler.appointmentservice.domain.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppointmentRepositoryImpl implements AppointmentRepository{

    private final SpringDataAppointmentRepository jpaRepository;


}
