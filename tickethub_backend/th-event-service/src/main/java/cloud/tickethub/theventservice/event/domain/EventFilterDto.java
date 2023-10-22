package cloud.tickethub.theventservice.event.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventFilterDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3632325812900502352L;
    private String title;
    private Integer city;
    private Integer category;
    private Long organizer;
    private Boolean online;
    private Boolean free;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private LocalDateTime startOn;
    private LocalDateTime endOn;



}
