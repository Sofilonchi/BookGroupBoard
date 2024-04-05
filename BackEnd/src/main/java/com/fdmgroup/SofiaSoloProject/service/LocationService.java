package com.fdmgroup.SofiaSoloProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.LocationRepository;
import com.fdmgroup.SofiaSoloProject.exceptions.NotAllowedException;
import com.fdmgroup.SofiaSoloProject.exceptions.NotFoundException;
import com.fdmgroup.SofiaSoloProject.model.Location;

@Service
public class LocationService {

	private LocationRepository locationRepository;

	@Autowired
	public LocationService(LocationRepository locationRepository) {
		
		super();
		this.locationRepository = locationRepository;
	
	}
	
	
	/////////////////////////////////////////////////////
	// DISPLAY
	/////////////////////////////////////////////////////
	
	public List<Location> findAll(){
		
		return this.locationRepository.findAll();
		
	}
	
	public Location findById(int locationId) {
		
		if (locationRepository.existsById(locationId)) {
			 return this.locationRepository.findById(locationId);
		}
		else {
			
			throw new NotFoundException("Location with ID: " + locationId + " cannot be found");
		}
		
	}
	
	
	/////////////////////////////////////////////////////
	// CREATE
	/////////////////////////////////////////////////////
	
	public void saveLocation(Location newLocation) {
		
		this.locationRepository.save(newLocation);
	
	}
	
	
	/////////////////////////////////////////////////////
	// UPDATE
	/////////////////////////////////////////////////////
	
	public void updateLocation(Location location) {
		
		if (locationRepository.existsById(location.getId())) {
			
			locationRepository.save(location);
			
		}
		else {
			
			throw new NotFoundException("Location ID: " + location.getId() + " cannot be found");
			
		}

	}
	
	
	/////////////////////////////////////////////////////
	// DELETE
	/////////////////////////////////////////////////////
	
	public void deleteById(int locationId) {
		
		throw new NotAllowedException("Location cannot be deleted");
		
	}
	
}
