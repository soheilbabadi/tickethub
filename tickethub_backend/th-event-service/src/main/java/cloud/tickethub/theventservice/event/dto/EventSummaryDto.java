package cloud.tickethub.theventservice.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventSummaryDto implements Serializable {


    @Serial
    private static final long serialVersionUID = 3632325812900502352L;

    private long id;

    private String title;


    private String city;

    private long cityId;


    private String organizer;

    private long organizerId;


    private String organizerImage;


    private boolean free;

    private boolean online;

    private boolean active;

    private BigDecimal price;

    private long categoryId;

}
