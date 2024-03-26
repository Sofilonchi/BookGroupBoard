package com.fdmgroup.SofiaSoloProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.SofiaSoloProject.model.Location;
import com.fdmgroup.SofiaSoloProject.service.LocationService;

@RestController
public class LocationController {

	
	private LocationService locationService;

	public LocationController(LocationService locationService) {
		
		super();
		this.locationService = locationService;
	
	}
	
	
	@GetMapping("locations")
	public List<Location> firstEndPoint(){
		
		return locationService.findAll();
	
	}
	
	@GetMapping("locations/{locationId}")
	public Location locationById(@PathVariable int locationId) {
		
		return locationService.findById(locationId);
		
	}
	
	@PostMapping("locations")
	public void createNewLocation(@RequestBody Location newLocation) {
		
		System.out.println(newLocation);
		locationService.saveLocation(newLocation);
		
	}
	
	
	@PutMapping("locations/{locationId}")
	public void updateLocation(@RequestBody Location location) {
		
		locationService.updateLocation(location);
		
	}
	
	@DeleteMapping("locations/{locationId}")
	public void deleteLocation(@PathVariable int locationId) {
		
		locationService.deleteById(locationId);
		
	}
}
