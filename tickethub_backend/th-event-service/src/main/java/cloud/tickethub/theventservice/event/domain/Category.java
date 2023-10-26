package cloud.tickethub.theventservice.event.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 8277037388684249544L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, targetEntity = Event.class, fetch = FetchType.EAGER)
    private List<Event> event;
}
