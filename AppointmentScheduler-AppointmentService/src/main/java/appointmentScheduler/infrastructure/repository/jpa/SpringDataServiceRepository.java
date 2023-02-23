package appointmentScheduler.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
