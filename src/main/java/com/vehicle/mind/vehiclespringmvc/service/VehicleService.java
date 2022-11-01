package com.vehicle.mind.vehiclespringmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.mind.vehiclespringmvc.model.Vehicle;
import com.vehicle.mind.vehiclespringmvc.repo.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository repo;

	public List<Vehicle> getAllVehicles() {
		return repo.findAll();
	}

	public void addVehicle(Vehicle vehicle) {
		repo.save(vehicle);
	}

	public Vehicle getVehicleByNumber(String id) {
		Optional<Vehicle> obj = repo.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}

		return null;
	}

}
