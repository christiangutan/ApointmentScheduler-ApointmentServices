package appointmentScheduler.domain;

import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Day {
    @Id
    @NotNull
    private LocalDate date;
    @NotNull
    private OpeningHours openingHours;
    @NotNull
    @Builder.Default
    private Set<Appointment> appointments = new HashSet<>();
}
