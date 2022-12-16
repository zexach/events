package com.dogadjaji.dogadjaji_188.controllers;

import com.dogadjaji.dogadjaji_188.models.Location;
import com.dogadjaji.dogadjaji_188.requests.LocationRequest;
import com.dogadjaji.dogadjaji_188.services.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {
    public final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getLocations(){
        return locationService.getLocations();
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable("id") Integer id){
        return locationService.getLocation(id);
    }

    @PostMapping
    public String addLocation(@RequestBody LocationRequest locationRequest){
        locationService.addLocation(locationRequest);
        return "You added new location successfully!";
    }

    @PutMapping("/{id}")
    public String updateLocation(@PathVariable("id") Integer id, @RequestBody LocationRequest locationRequest){
        locationService.updateLocation(id, locationRequest);
        return "You update location succcessfully!";
    }
}
