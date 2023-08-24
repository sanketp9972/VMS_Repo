package com.app.controller;

import com.app.dto.CarFinanceDTO;
import com.app.entity.CarFinance;
import com.app.service.CarFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/finance")
public class CarFinanceController {

    private final CarFinanceService carFinanceService;

    @Autowired
    public CarFinanceController(CarFinanceService carFinanceService) {
        this.carFinanceService = carFinanceService;
    }

    @PostMapping
    public ResponseEntity<CarFinanceDTO> createCarFinance(@RequestBody CarFinanceDTO carFinanceDto) {
    	CarFinanceDTO createdCarFinance = carFinanceService.createCarFinance(carFinanceDto);
        return new ResponseEntity<>(createdCarFinance, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarFinance>> getAllCarFinances() {
        List<CarFinance> carFinances = carFinanceService.getAllCarFinances();
        return new ResponseEntity<>(carFinances, HttpStatus.OK);
    }

    @GetMapping("/{financeId}")
    public ResponseEntity<CarFinanceDTO> getCarFinanceById(@PathVariable Long financeId) {
    	CarFinanceDTO carFinance = carFinanceService.getCarFinanceById(financeId);
        if (carFinance != null) {
            return new ResponseEntity<>(carFinance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{financeId}")
    public ResponseEntity<CarFinanceDTO> updateCarFinance(
            @PathVariable Long financeId,
            @RequestBody CarFinanceDTO carFinanceDto
    ) {
    	CarFinanceDTO updatedCarFinance = carFinanceService.updateCarFinance(financeId, carFinanceDto);
        if (updatedCarFinance != null) {
            return new ResponseEntity<>(updatedCarFinance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{financeId}")
    public ResponseEntity<Void> deleteCarFinance(@PathVariable Long financeId) {
        carFinanceService.deleteCarFinance(financeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
