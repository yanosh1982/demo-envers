package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements com.example.demo.DemoService{

	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Driver save(Driver driver) {
		return driverRepository.save(driver);
	}

	@Override
	public Optional<Vehicle> find(Integer id) {
		return vehicleRepository.findById(id);
	}

}
