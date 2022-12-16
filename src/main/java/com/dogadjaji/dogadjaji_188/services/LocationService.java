package com.dogadjaji.dogadjaji_188.services;

import com.dogadjaji.dogadjaji_188.models.Location;
import com.dogadjaji.dogadjaji_188.repositories.LocationRepository;
import com.dogadjaji.dogadjaji_188.requests.LocationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    public Location getLocation(int id){
        return locationRepository.findById(id).orElseThrow();
    }

    public void addLocation(LocationRequest locationRequest){
        Location location = new Location();

        location.setName(locationRequest.getName());
        location.setDescription(locationRequest.getDescription());
        location.setImage(locationRequest.getImage());

        locationRepository.save(location);
    }

    public void updateLocation(int id, LocationRequest locationRequest){
        Location location = getLocation(id);

        location.setName(locationRequest.getName());
        location.setDescription(locationRequest.getDescription());
        location.setImage(locationRequest.getImage());

        locationRepository.save(location);
    }
}
