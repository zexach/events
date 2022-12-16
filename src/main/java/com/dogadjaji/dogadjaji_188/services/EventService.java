package com.dogadjaji.dogadjaji_188.services;

import com.dogadjaji.dogadjaji_188.models.Category;
import com.dogadjaji.dogadjaji_188.models.Event;
import com.dogadjaji.dogadjaji_188.models.Location;
import com.dogadjaji.dogadjaji_188.repositories.CategoryRepository;
import com.dogadjaji.dogadjaji_188.repositories.EventsRepository;
import com.dogadjaji.dogadjaji_188.repositories.LocationRepository;
import com.dogadjaji.dogadjaji_188.requests.EventRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventsRepository eventsRepository;
    private final LocationRepository locationRepository;
    private final CategoryRepository categoryRepository;

    public EventService(EventsRepository eventsRepository, LocationRepository locationRepository, CategoryRepository categoryRepository) {
        this.eventsRepository = eventsRepository;
        this.locationRepository = locationRepository;
        this.categoryRepository = categoryRepository;
    }
    public List<Event> getEvents(){
        return eventsRepository.findAll();
    }
    public Event getEvent(int id){
        return eventsRepository.findById(id).orElseThrow();
    }
    public void addEvent(EventRequest eventRequest){

        Location location = locationRepository.findById(eventRequest.getLocationID()).orElseThrow();

        Category category = categoryRepository.findById(eventRequest.getCategoryID()).orElseThrow();

        Event event = new Event();
        event.setName(eventRequest.getName());
        event.setDescription(eventRequest.getDescription());
        event.setDate(eventRequest.getDate());
        event.setImgUrl(eventRequest.getImgUrl());
        event.setLocation(location);
        event.setCategory(category);

        eventsRepository.save(event);
    }

    public void updateEvent(int id, EventRequest eventRequest){
        Event currentEvent = getEvent(id);

        currentEvent.setName(eventRequest.getName());
        currentEvent.setDescription(eventRequest.getDescription());
        currentEvent.setDate(eventRequest.getDate());
        currentEvent.setImgUrl(eventRequest.getImgUrl());

        eventsRepository.save(currentEvent);
    }

    public void deleteEvent(int id){
        eventsRepository.deleteById(id);
    }

}
