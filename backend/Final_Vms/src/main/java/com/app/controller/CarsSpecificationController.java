package com.app.controller;

import com.app.dto.CarBookingDTO;
import com.app.dto.CarSpecificationDTO;
import com.app.entity.CarBooking;
import com.app.entity.CarsSpecification;
import com.app.service.CarsSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car_spec")
public class CarsSpecificationController {
    private final CarsSpecificationService specificationService;

    @Autowired
    public CarsSpecificationController(CarsSpecificationService specificationService) {
        this.specificationService = specificationService;
    }

    @PostMapping
    public ResponseEntity<CarsSpecification> createCarsSpecification(@RequestBody CarSpecificationDTO carsSpecification) {
        CarsSpecification createdSpecification = specificationService.addSpec(carsSpecification);
        return new ResponseEntity<>(createdSpecification, HttpStatus.CREATED);
    }
    


    @GetMapping("/{id}")
    public ResponseEntity<CarsSpecification> getCarSpecificationById(@PathVariable Long id) {
        CarsSpecification carSpecification = specificationService.getCarSpecificationById(id);
        return ResponseEntity.ok(carSpecification);
    }

    @GetMapping
    public ResponseEntity<List<CarsSpecification>> getAllCarSpecifications() {
        List<CarsSpecification> allSpecifications = specificationService.getAllCarSpecifications();
        return ResponseEntity.ok(allSpecifications);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarsSpecification> updateCarsSpecification(
            @PathVariable Long id, @RequestBody CarSpecificationDTO updatedSpec) {
        CarsSpecification updatedSpecification = specificationService.updateCarsSpecification(id, updatedSpec);
        return ResponseEntity.ok(updatedSpecification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarSpecification(@PathVariable Long id) {
        specificationService.deleteCarSpecification(id);
        return ResponseEntity.noContent().build();
    }
}