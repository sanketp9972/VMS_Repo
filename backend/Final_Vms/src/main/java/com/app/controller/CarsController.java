package com.app.controller;

import com.app.dto.CarRequestDTO;
import com.app.dto.CarsDTO;
import com.app.entity.Cars;
import com.app.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "http://localhost:3000")
public class CarsController {

    @Autowired
    private CarsService carsService;



    @DeleteMapping("/{carId}")
    public ResponseEntity<?> deleteCar(@PathVariable Long carId) {
        carsService.deleteCar(carId);
        return ResponseEntity.ok("Car deleted successfully");
    }

    @PutMapping("/{carId}")
    public ResponseEntity<Cars> updateCar(@PathVariable Long carId, @RequestBody CarRequestDTO carRequestDTO) {
        Cars updatedCar = carsService.updateCar(carId, carRequestDTO);
        if (updatedCar != null) {
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


   
    @GetMapping("/by-brand-model")
    public ResponseEntity<Cars> getCarByBrandAndModelWithSpec(@RequestParam String brandName, @RequestParam String modelName) {
        Optional<Cars> car = carsService.getCarByBrandAndModelWithSpec(brandName, modelName);
        if (car.isPresent()) {
            return new ResponseEntity<>(car.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
   
        @PostMapping
        public ResponseEntity<Cars> createCar(@RequestBody CarRequestDTO carRequestDTO) {
            Cars savedCar = carsService.createCar(carRequestDTO);
            return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
        }
        @GetMapping("/{carId}")
        public Cars getCarWithSpecById(@PathVariable Long carId) {
            return carsService.findCarWithSpecificationById(carId);
        }
        
        
        @GetMapping
        public List<Cars> getAllCarsWithSpec2() {
            return carsService.getAllCarsWithSpec2();
        }

        @GetMapping("/withoutspec")
        public List<Cars> getAllCarsWithoutSpec2() {
            return carsService.getAllCarsWithoutSpec2();
        }
        
        @GetMapping("/details")
        public List<Cars> getCarDetailsByBrandOrModel(
            @RequestParam(value = "brandName", required = false) String brandName,
            @RequestParam(value = "modelName", required = false) String modelName) {
            
            if (brandName != null) {
                // Search by brandName
                return carsService.getCarDetailsByBrandOrModel(brandName, null);
            } else if (modelName != null) {
                // Search by modelName
                return carsService.getCarDetailsByBrandOrModel(null, modelName);
            } else {
                // Both brandName and modelName are null, return an empty list or handle as needed.
                return Collections.emptyList();
            }
        }

        
    }


