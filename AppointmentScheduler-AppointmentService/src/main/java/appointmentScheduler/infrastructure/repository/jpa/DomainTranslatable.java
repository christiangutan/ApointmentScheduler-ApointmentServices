package appointmentScheduler.infrastructure.repository.jpa;

public interface DomainTranslatable<T> {

    T toDomain();

}
