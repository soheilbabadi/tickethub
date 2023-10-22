package cloud.tickethub.theventservice.event.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class EventPhoto implements Serializable {


    @Serial
    private static final long serialVersionUID = -747711197555455354L;

    @Id
    private String id;

    private byte[] fileContent;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String contentType;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String originalPhotoName;

    @Column(nullable = false)
    private long photoSize;

    @Column(nullable = false)
    private LocalDateTime createOn;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String createdBy;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String photoUrl;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Event.class)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;



}
