package com.itana.backendapplication.repository;

import com.itana.backendapplication.entity.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* VehicleRepository
*/
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
