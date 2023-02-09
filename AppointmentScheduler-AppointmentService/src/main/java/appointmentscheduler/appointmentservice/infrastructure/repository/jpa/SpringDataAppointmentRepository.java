package appointmentscheduler.appointmentservice.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataAppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
}
