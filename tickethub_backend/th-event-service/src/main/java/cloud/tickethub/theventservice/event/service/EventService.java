package cloud.tickethub.theventservice.event.service;

import cloud.tickethub.theventservice.event.domain.EventDto;
import cloud.tickethub.theventservice.event.domain.EventFilterDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface EventService {
    @Cacheable(value = "events", key = "#dto", unless = "#result.size() == 0", condition = "#dto != null", sync = true)
    List<EventDto> findAll(EventFilterDto dto);

    EventDto addEvent(EventDto dto);

    EventDto updateEvent(EventDto dto);

    @Cacheable(value = "events", key = "#id")
    EventDto getEvent(long id);

    @CacheEvict(value = "events", allEntries = true)
    void deleteEvent(long id);

    EventDto closeEvent(long id);

}
