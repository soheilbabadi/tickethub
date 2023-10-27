package cloud.tickethub.theventservice.event.dto;

import cloud.tickethub.theventservice.event.domain.EventAlbum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class AlbumPhoto implements Serializable {

    private static final long serialVersionUID = -747711197555455354L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private char[] fileContent;
    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String contentType;
    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String originalPhotoName;

    private long photoSize;
    private LocalDateTime createOn;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String createdBy;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String photoUrl;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = EventAlbum.class)
    @JoinColumn(name = "event_album_id", referencedColumnName = "id")
    private EventAlbum eventAlbum;
}

