package appointmentScheduler.infrastructure.repository.jpa;

import appointmentScheduler.domain.Service;
import appointmentScheduler.domain.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServiceRepositoryImpl implements ServiceRepository {

    private final SpringDataServiceRepository serviceJpaRepository;

    @Override
    public List<Service> getServices() {
        return serviceJpaRepository.findAll().stream().map(ServiceEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Service> getServiceById(Long id) {
        return serviceJpaRepository.findById(id).map(ServiceEntity::toDomain);
    }

    @Override
    public Long createService(Service service) {
        ServiceEntity serviceEntity = ServiceEntity.fromDomain(service);
        return serviceJpaRepository.save(serviceEntity).getId();
    }

    @Override
    public void deleteService(Long id) {
        serviceJpaRepository.deleteById(id);
    }
}
