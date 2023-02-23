package appointmentScheduler.domain;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SplitOpeningHours extends OpeningHours{
    @NotNull
    private LocalTime morningOpeningTime;
    @NotNull
    private LocalTime morningClosingTime;
    @NotNull
    private LocalTime eveningOpeningTime;
    @NotNull
    private LocalTime eveningClosingTime;
}
