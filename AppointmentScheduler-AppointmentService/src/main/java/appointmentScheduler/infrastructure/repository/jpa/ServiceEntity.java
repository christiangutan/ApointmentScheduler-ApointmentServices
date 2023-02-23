package appointmentScheduler.infrastructure.repository.jpa;

import appointmentScheduler.domain.Service;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString(exclude = "appointments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service")
public class ServiceEntity implements DomainTranslatable<Service> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private int duration;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    private Set<AppointmentEntity> appointments = new HashSet<>();

    @Override
    public Service toDomain() {
        return Service.builder()
                .id(id)
                .duration(duration)
                .name(name)
                .description(description)
                .build();
    }

    public static ServiceEntity fromDomain(Service service) {
        if(service == null) {
            return null;
        }

        return ServiceEntity.builder()
                .id(service.getId())
                .name(service.getName())
                .description(service.getDescription())
                .duration(service.getDuration())
                .build();
    }



}
