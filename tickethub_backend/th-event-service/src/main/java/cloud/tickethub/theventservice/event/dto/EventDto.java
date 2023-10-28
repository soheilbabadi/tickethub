package cloud.tickethub.theventservice.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -4101476875571981510L;

    private long id;

    private String title;

    private String description;

    private String address;

    private String city;

    private long cityId;


    private int capacity;

    private int registerCount;

    private double latitude;
    private double longitude;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerStartOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerEndOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateOn;


    private String banner;

    private String organizer;

    private long organizerId;

    private String organizerDescription;

    private String organizerImage;

    private String organizerEmail;

    private String organizerPhone;

    private String organizerWebsite;

    private String organizerInstagram;

    private String organizerTwitter;

    private String organizerLinkedin;

    private String organizerTelegram;

    private boolean free;

    private boolean online;

    private boolean active;

    private BigDecimal price;

    private String category;

    private long categoryId;


}
