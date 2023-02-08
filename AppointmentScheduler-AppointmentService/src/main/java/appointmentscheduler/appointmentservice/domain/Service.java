package appointmentscheduler.appointmentservice.domain;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private Long id;
    private String name;
    private String description;
    private int duration;
}
