package appointmentscheduler.appointmentservice.infrastructure.repository.jpa;

import appointmentscheduler.appointmentservice.domain.Appointment;
import appointmentscheduler.appointmentservice.domain.Service;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class AppointmentEntity implements DomainTranslatable<Appointment> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date")
    private LocalDateTime date;     //Puede que el la clase LocalDateTime dé problemas en la DDBB ?

    @ManyToOne
    //@JoinColumn(name = "id_service", referencedColumnName = "id")
    private ServiceEntity service;

    @Override
    public Appointment toDomain() {
        return Appointment.builder()
                .id(id)
                .description(description)
                .date(date)
                .service(service.toDomain())
                .build();
    }

    public static AppointmentEntity fromDomain(Appointment appointment) {
        if(appointment == null) {
            return null;
        }

        return AppointmentEntity.builder()
                .id(appointment.getId())
                .description(appointment.getDescription())
                .date(appointment.getDate())
                .service(ServiceEntity.fromDomain(appointment.getService()))
                .build();
    }
}
