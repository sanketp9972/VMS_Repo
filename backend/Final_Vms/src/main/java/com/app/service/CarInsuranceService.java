package com.app.service;

import java.util.List;

import com.app.dto.InsuranceDTO;
import com.app.dto.UsersDTO;
import com.app.entity.CarInsurance;

public interface CarInsuranceService {
	
	//get all carInsurance Details
	List<CarInsurance> getAllInsurance();
	
	//Get Insurance Details From insuranceId
	CarInsurance getInsuranceDetails(Long insuranceId);
	
	//add new Insurance Details
//	CarInsurance addNewInsurance(InsuranceDTO insuranceDTO);
	CarInsurance addNewInsurance(CarInsurance insurance);
	
		

}
