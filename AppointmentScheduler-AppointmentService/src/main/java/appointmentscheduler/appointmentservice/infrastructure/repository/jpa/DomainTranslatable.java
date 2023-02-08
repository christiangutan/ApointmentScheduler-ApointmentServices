package appointmentscheduler.appointmentservice.infrastructure.repository.jpa;

public interface DomainTranslatable<T> {
    T toDomain();
}
