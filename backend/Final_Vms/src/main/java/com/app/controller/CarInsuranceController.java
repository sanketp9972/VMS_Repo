package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.CarInsurance;
import com.app.service.CarInsuranceService;


@RestController
@RequestMapping("/insurance")
@CrossOrigin(origins = "http://localhost:3000")
public class CarInsuranceController {
	
	@Autowired
	private CarInsuranceService insuranceService;
	
	@GetMapping
    public List<CarInsurance> getInsurance(){
		return insuranceService.getAllInsurance();
	}
		
//	@PostMapping
//	public ResponseEntity<CarInsurance> saveInsurance(@RequestBody InsuranceDTO insuranceDTO){
//		CarInsurance addInsurance = insuranceService.addNewInsurance(insuranceDTO);
//		return ResponseEntity.ok(addInsurance);
//	}
	
	@PostMapping
	public CarInsurance saveInsurance(@RequestBody CarInsurance insurance){
		System.out.println(insurance.toString());
		return insuranceService.addNewInsurance(insurance);
	}
	
	
	@PutMapping
	public CarInsurance updateInsurance(@RequestBody CarInsurance detachedInsurance){
		System.out.println("Update Sucessfull "+detachedInsurance.getInsuranceId());
		
		insuranceService.getInsuranceDetails(detachedInsurance.getInsuranceId());
		return insuranceService.addNewInsurance(detachedInsurance);
	}


}
