package com.dogadjaji.dogadjaji_188.controllers;

import com.dogadjaji.dogadjaji_188.models.Category;
import com.dogadjaji.dogadjaji_188.models.Event;
import com.dogadjaji.dogadjaji_188.models.Location;
import com.dogadjaji.dogadjaji_188.requests.EventRequest;
import com.dogadjaji.dogadjaji_188.services.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable("id") Integer id){
        return eventService.getEvent(id);
    }

    @PostMapping
    public String addEvent(@RequestBody EventRequest eventRequest){
        eventService.addEvent(eventRequest);
        return "You added new event successfully";
    }

    @PutMapping("/{id}")
    public String updateEvent(@PathVariable("id") Integer id, @RequestBody EventRequest eventRequest){
        eventService.updateEvent(id, eventRequest);
        return "Event updated successfully";
    }

    @DeleteMapping("/{eventID}")
    public String deleteEvent(@PathVariable("eventID") Integer id){
        eventService.deleteEvent(id);
        return "Event deleted successfully";
    }

}
