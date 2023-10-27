package cloud.tickethub.theventservice.event.domain;

import cloud.tickethub.theventservice.event.dto.AlbumPhoto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class EventAlbum implements Serializable {
    @Serial
    private static final long serialVersionUID = -4212835722170259595L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String description;
    private String cover;
    private LocalDateTime createOn;
    private String createdBy;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Event.class)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @OneToMany(mappedBy = "eventAlbum", cascade = CascadeType.ALL, targetEntity = AlbumPhoto.class, fetch = FetchType.EAGER)
    private List<AlbumPhoto> albumPhoto;

}
