package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.CarServiceDTO;
import com.app.dto.CarServiceUpdateDTO;
import com.app.entity.CarServices;
import com.app.service.CarServicesService;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:3000")
public class CarServicesContoller {

	@Autowired
	private CarServicesService carService;
	
	@GetMapping
	public List<CarServices> getAllServices(){
		
		return carService.getServices();
	}
	
	 @PostMapping("/add")
    public ResponseEntity<String> addService(@RequestBody CarServiceDTO serviceDTO) {
        String result = carService.addService(serviceDTO);
        if (result.equals("Service added successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
	
	 
	 //---------------------------------------
	 @PutMapping("/{carId}/{serviceId}")
	    public ResponseEntity<String> updateService(
	            @PathVariable Long carId,
	            @PathVariable Long serviceId,
	            @RequestBody CarServiceUpdateDTO serviceDTO
	    ) {
	        String result = carService.updateService(carId, serviceId, serviceDTO);
	        if (result.equals("Service updated successfully")) {
	            return ResponseEntity.status(HttpStatus.OK).body(result);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
	        }
	    }
	
}
