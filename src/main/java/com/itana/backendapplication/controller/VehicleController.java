package com.itana.backendapplication.controller;

import java.util.List;

import com.itana.backendapplication.entity.Vehicle;
import com.itana.backendapplication.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* VehicleController
*/
@RestController
@RequestMapping("/api")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	@GetMapping(path = "/vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Vehicle>> fetchAll(){
		try {
			List<Vehicle> optionalVehiclesList = vehicleService.findAll();
			if (!optionalVehiclesList.isEmpty()) {
				return new ResponseEntity<List<Vehicle>>(optionalVehiclesList,HttpStatus.OK);
			}else{
				return new ResponseEntity<List<Vehicle>>(HttpStatus.NOT_FOUND);
			}
			
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
