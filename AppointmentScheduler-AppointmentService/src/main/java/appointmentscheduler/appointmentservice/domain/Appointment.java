package appointmentscheduler.appointmentservice.domain;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private Long id;
    private String description;
    private LocalDateTime date; // LocalDateTime fechaHora = LocalDateTime.of(2022, 1, 1, 12, 30);
    private Service service;
}
