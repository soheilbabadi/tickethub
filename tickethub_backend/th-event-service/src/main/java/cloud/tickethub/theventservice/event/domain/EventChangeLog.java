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
public class EventChangeLog implements Serializable {

    @Serial
    private static final long serialVersionUID = -5603590196280852561L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String changeLog;

    private LocalDateTime changeOn;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Event.class)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

}
