package com.vehicle.mind.vehiclespringmvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.mind.vehiclespringmvc.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
