package cloud.tickethub.theventservice.event.infra;

import cloud.tickethub.theventservice.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {


    List<Event> findAllByActive(boolean active);

    List<Event> findAllByOrganizerIdOrderByStartOnDesc(long organizerId);

}
