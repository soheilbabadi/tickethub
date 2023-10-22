package cloud.tickethub.theventservice.event.infra;

import cloud.tickethub.theventservice.event.domain.Category;
import cloud.tickethub.theventservice.event.domain.Event;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {



    @Cacheable("events")
    List<Event> findAllByActive(boolean active);

}
