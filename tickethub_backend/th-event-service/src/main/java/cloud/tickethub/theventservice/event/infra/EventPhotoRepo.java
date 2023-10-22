package cloud.tickethub.theventservice.event.infra;

import cloud.tickethub.theventservice.event.domain.Event;
import cloud.tickethub.theventservice.event.domain.EventPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;


@Repository
public interface EventPhotoRepo extends JpaRepository<EventPhoto, String> {

    List<EventPhoto> findAllByEvent(Event event);
    void deleteAllByEvent(Event event);
}
