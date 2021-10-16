package com.itana.backendapplication.controller;

import java.util.List;

import javax.validation.Valid;

import com.itana.backendapplication.entity.Vehicle;
import com.itana.backendapplication.resource.SaveVehicleResource;
import com.itana.backendapplication.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	private Vehicle ResourceToEntity(SaveVehicleResource resource){
		Vehicle newVehicle = new Vehicle();
		newVehicle.setYear(resource.getYear());
		newVehicle.setType(resource.getType());
		newVehicle.setNumber(resource.getNumber());
		newVehicle.setCategory(resource.getCategory());
		return newVehicle;
	}
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

	//TODO: add resource to update vehicle entity
	@PutMapping(path = "/vehicle/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vehicle> update(@Valid @RequestBody SaveVehicleResource resource, @PathVariable Long id){
		try {
			if(vehicleService.findById(id).isPresent()){
				Vehicle entity = ResourceToEntity(resource);
				entity.setId(id);
				Vehicle updatedVehicle = vehicleService.update(entity);
				return new ResponseEntity<Vehicle>(updatedVehicle,HttpStatus.OK);
			}else{
				return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//TODO: add resource to add vehicle
	@PostMapping(path = "/vehicles/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vehicle> create(@RequestBody SaveVehicleResource resource)throws Exception{
		try {
			Vehicle entity = ResourceToEntity(resource);
			Vehicle newVehicle = vehicleService.save(entity);
			return new ResponseEntity<Vehicle>(newVehicle, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/vehicles/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteEntity(@PathVariable long id){
		try {
			vehicleService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
