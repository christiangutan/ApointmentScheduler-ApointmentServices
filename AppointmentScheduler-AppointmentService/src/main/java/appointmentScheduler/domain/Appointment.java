package appointmentScheduler.domain;

import lombok.*;

import java.time.LocalTime;


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
    private LocalTime startTime;
    private LocalTime endTime;
    private int totalTime;

    private Service service;
    private User employee;
}
