package appointmentScheduler.domain;

import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class OpeningHours {
    private Long id;
    @NotNull
    private String label;     // name
}
