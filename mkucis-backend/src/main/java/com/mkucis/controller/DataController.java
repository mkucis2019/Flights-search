package com.mkucis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mkucis.entity.Airport;
import com.mkucis.repository.AirportRepository;

@RestController
@CrossOrigin
public class DataController {
	
	@Autowired
	private AirportRepository repository;
	
	@GetMapping(value = "/data/airport")
	public List<Airport> getAirportData() {
		return repository.findAll();
	}
	
	@PostMapping(value = "/data/airport")
	public Airport saveAirportData(@RequestBody Airport airport) {
		return repository.saveAndFlush(airport);
	}
	
	@DeleteMapping(value = "/data/airport/{id}")
	public void deleteAirportData(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}
