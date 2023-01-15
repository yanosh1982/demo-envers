package com.example.demo;

import java.util.Optional;

public interface DemoService {

	public Vehicle save(Vehicle vehicle);
	
	public Driver save(Driver driver);
	
	public Optional<Vehicle> find(Integer id);
	
}
