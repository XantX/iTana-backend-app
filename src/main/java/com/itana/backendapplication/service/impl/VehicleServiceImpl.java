package com.itana.backendapplication.service.impl;

import java.util.List;
import java.util.Optional;

import com.itana.backendapplication.entity.Vehicle;
import com.itana.backendapplication.repository.VehicleRepository;
import com.itana.backendapplication.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* VehicleServiceImpl
*/
@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle save(Vehicle entity) throws Exception {
		return vehicleRepository.save(entity);
	}

	@Override
	public List<Vehicle> findAll() throws Exception {
		return vehicleRepository.findAll();
	}

	@Override
	public Optional<Vehicle> findById(Long id) throws Exception {
		return vehicleRepository.findById(id);
	}

	@Override
	public Vehicle update(Vehicle entity) throws Exception {
		return vehicleRepository.save(entity);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		vehicleRepository.deleteById(id);
	}
	
}
