package cloud.tickethub.theventservice.event.infra;

import cloud.tickethub.theventservice.event.domain.Category;
import cloud.tickethub.theventservice.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

List<Event> findAllByCityId(long cityId);
List<Event> findAllByTitleContaining(String title);
List<Event> findAllByOrganizerId(long organizerId);

List<Event> findAllByCategory(Category category);
List<Event> findAllByOnline(boolean online);
List<Event> findAllByPriceBetween(BigDecimal min, BigDecimal max);




}
