package cloud.tickethub.theventservice.event.service;

import cloud.tickethub.theventservice.event.domain.Category;
import cloud.tickethub.theventservice.event.domain.Event;
import cloud.tickethub.theventservice.event.domain.EventDto;
import cloud.tickethub.theventservice.event.domain.EventFilterDto;
import cloud.tickethub.theventservice.event.infra.CategoryRepo;
import cloud.tickethub.theventservice.event.infra.EventRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    @Cacheable(value = "events", key = "#dto", unless = "#result.size() == 0", condition = "#dto != null", sync = true)
    public List<EventDto> findAll(EventFilterDto dto) {
        return convertToDto(findAllByFilter(dto));
    }


    @Override
    public EventDto addEvent(EventDto dto) {
        Event event = new Event();
        BeanUtils.copyProperties(dto, event);
        event.setCategory(getCategoryById(dto.getCategoryId()));
        event.setRegisterOn(LocalDateTime.now(ZoneId.of("UTC")));
        event.setUpdateOn(LocalDateTime.now(ZoneId.of("UTC")));

        eventRepo.save(event);
        dto.setId(event.getId());
        return dto;
    }

    @Override
    public EventDto updateEvent(EventDto dto) {
        var event = eventRepo.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Event not found"));
        BeanUtils.copyProperties(dto, event);
        event.setCategory(getCategoryById(dto.getCategoryId()));
        event.setUpdateOn(LocalDateTime.now(ZoneId.of("UTC")));
        return dto;
    }


    @Override
    @Cacheable(value = "events", key = "#id")
    public EventDto getEvent(long id) {
        var event = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        var dto = new EventDto();
        BeanUtils.copyProperties(event, dto);
        dto.setCategoryId(event.getCategory().getId());
        dto.setCategory(event.getCategory().getTitle());
        return dto;
    }

    @Override
    @CacheEvict(value = "events", allEntries = true)
    public void deleteEvent(long id) {
        var event = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        eventRepo.delete(event);
    }

    @Override
    public EventDto closeEvent(long id) {
        Event event = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        event.setUpdateOn(LocalDateTime.now(ZoneId.of("UTC")));
        event.setActive(false);
        event.setRegisterEndOn(LocalDateTime.now(ZoneId.of("UTC")));
        eventRepo.save(event);

        var dto = new EventDto();
        BeanUtils.copyProperties(event, dto);
        dto.setCategoryId(event.getCategory().getId());
        dto.setCategory(event.getCategory().getTitle());
        return dto;

    }

    private List<Event> findAllByFilter(EventFilterDto dto) {

        List<Event> list = eventRepo.findAll();

        if (dto.getTitle() != null)
            list = list.stream().filter(event -> event.getTitle().contains(dto.getTitle())).toList();

        if (dto.getCity() != null)
            list = list.stream().filter(event -> event.getCityId() == dto.getCity()).toList();

        if (dto.getCategory() != null)
            list = list.stream().filter(event -> event.getCategory().getId() == dto.getCategory()).toList();

        if (dto.getOrganizer() != null)
            list = list.stream().filter(event -> event.getOrganizerId() == dto.getOrganizer()).toList();

        if (dto.getOnline())
            list = list.stream().filter(Event::isOnline).toList();

        if (dto.getMaxPrice() != null && dto.getMinPrice() != null)
            list = list.stream().filter(event -> event.getPrice().compareTo(dto.getMinPrice()) >= 0 && event.getPrice().compareTo(dto.getMaxPrice()) <= 0).toList();

        if (dto.getStartOn() != null)
            list = list.stream().filter(event -> event.getStartOn().isAfter(dto.getStartOn())).toList();

        if (dto.getEndOn() != null)
            list = list.stream().filter(event -> event.getEndOn().isBefore(dto.getEndOn())).toList();

        if (dto.getFree())
            list = list.stream().filter(event -> event.getPrice().compareTo(BigDecimal.ZERO) == 0).toList();

        return list;
    }

    private List<EventDto> convertToDto(List<Event> eventList) {
        return eventList.stream().map(event -> {
            var dto = new EventDto();
            BeanUtils.copyProperties(event, dto);
            dto.setCategory(event.getCategory().getTitle());
            dto.setCategoryId(event.getCategory().getId());
            return dto;
        }).toList();
    }


    private Category getCategoryById(long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }
}