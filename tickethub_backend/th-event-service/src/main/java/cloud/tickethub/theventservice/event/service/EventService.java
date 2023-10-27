package cloud.tickethub.theventservice.event.service;

import cloud.tickethub.theventservice.event.dto.EventDto;
import cloud.tickethub.theventservice.event.dto.EventFilterDto;
import cloud.tickethub.theventservice.event.dto.EventSummaryDto;

import java.util.List;

public interface EventService {

    List<EventSummaryDto> findAll(EventFilterDto dto);

    EventDto addEvent(EventDto dto);

    EventDto updateEvent(EventDto dto);

    EventDto getEvent(long id);

    void deleteEvent(long id);

    EventDto closeEvent(long id);

}
