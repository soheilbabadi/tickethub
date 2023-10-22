package cloud.tickethub.theventservice.event.domain;

import jakarta.persistence.*;
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
@Entity
public class EventDto implements Serializable {


    @Serial
    private static final long serialVersionUID = 2835174747968614937L;

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
    private LocalDateTime startOn;
    private LocalDateTime endOn;


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

    private int categoryId;


}
