package cloud.tickethub.theventservice.event.presentation;


import cloud.tickethub.theventservice.event.domain.EventDto;
import cloud.tickethub.theventservice.event.domain.EventFilterDto;
import cloud.tickethub.theventservice.event.domain.EventSummaryDto;
import cloud.tickethub.theventservice.event.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    @Autowired
    private EventService eventService;


    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable long id) {
        return new ResponseEntity<>(eventService.getEvent(id), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<EventSummaryDto>> searchEvent(@RequestBody @Valid EventFilterDto dto) {
        return new ResponseEntity<>(eventService.findAll(dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventDto> addEvent(@RequestBody @Valid EventDto dto) {
        return new ResponseEntity<>(eventService.addEvent(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EventDto> updateEvent(@RequestBody @Valid EventDto dto) {
        return new ResponseEntity<>(eventService.updateEvent(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/close/{id}")
    public ResponseEntity<EventDto> closeEvent(@PathVariable long id) {
        return new ResponseEntity<>(eventService.closeEvent(id), HttpStatus.OK);
    }
}
