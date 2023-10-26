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
public class Event implements Serializable {

    @Serial
    private static final long serialVersionUID = 8277037388684249544L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(length = 1000, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 150, columnDefinition = "VARCHAR(150)")
    private String address;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String city;

    @Column(nullable = false)
    private long cityId;


    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private int registerCount;

    private double latitude;
    private double longitude;
    private LocalDateTime startOn;
    private LocalDateTime endOn;

    private LocalDateTime registerStartOn;
    private LocalDateTime registerEndOn;
    private LocalDateTime registerOn;
    private LocalDateTime updateOn;


    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String banner;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String organizer;

    @Column(nullable = false)
    private long organizerId;

    @Column(columnDefinition = "TEXT")
    private String organizerDescription;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String organizerImage;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String organizerEmail;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String organizerPhone;

    @Column(length = 50, columnDefinition = "VARCHAR(50)")
    private String organizerWebsite;

    @Column(length = 50, columnDefinition = "VARCHAR(50)")
    private String organizerInstagram;

    @Column(length = 50, columnDefinition = "VARCHAR(50)")
    private String organizerTwitter;

    @Column(length = 50, columnDefinition = "VARCHAR(50)")
    private String organizerLinkedin;

    @Column(length = 50, columnDefinition = "VARCHAR(50)")
    private String organizerTelegram;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean free;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean online;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean active;

    @Column(nullable = false)
    private BigDecimal price;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = EventAlbum.class)
    private EventAlbum eventAlbum;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = EventPhoto.class)
    private EventPhoto eventPhoto;

}
