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
public class ContinuousOpeningHours extends OpeningHours{
    private LocalTime openingTime;
    private LocalTime closingTime;
}
