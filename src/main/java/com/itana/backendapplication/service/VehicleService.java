package com.itana.backendapplication.service;

import com.itana.backendapplication.entity.Vehicle;

import org.springframework.stereotype.Service;

/**
* VehicleService
*/
@Service
public interface VehicleService extends CrudService<Vehicle,Long> {
}
