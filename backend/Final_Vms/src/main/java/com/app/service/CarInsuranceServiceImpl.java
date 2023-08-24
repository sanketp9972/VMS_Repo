package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.InsuranceDTO;
import com.app.dto.UsersDTO;
import com.app.entity.CarBooking;
import com.app.entity.CarInsurance;
import com.app.entity.Cars;
import com.app.entity.Users;
import com.app.repository.CarBookingRepository;
import com.app.repository.CarInsuranceRepository;
import com.app.repository.CarServicesRepository;

@Service
@Transactional
public class CarInsuranceServiceImpl implements CarInsuranceService {
	
	@Autowired
	private CarInsuranceRepository carInsuranceRepo;
	
	@Autowired
    private ModelMapper modelMapper;

	//For EndUser
	@Override
	public List<CarInsurance> getAllInsurance() {
		return carInsuranceRepo.findAll();
	}

	//for EndUser
	@Override
	public CarInsurance getInsuranceDetails(Long insuranceId) {
		
		return carInsuranceRepo.findById(insuranceId).orElseThrow(() -> new ResourceNotFoundException("No such Insurance Found"));
	}

	//For Admin
//	@Override
//	public CarInsurance addNewInsurance(InsuranceDTO insuranceDTO) {
//		System.out.println(insuranceDTO.toString());
//		CarInsurance insurance = convertToEntity(insuranceDTO);
//		System.out.println(insurance.toString());
//		return  carInsuranceRepo.save(insurance);
//	}
	
	@Override
	public CarInsurance addNewInsurance(CarInsurance insurance) {
		
		return carInsuranceRepo.save(insurance);
	}

	
	
	private CarInsurance convertToEntity(InsuranceDTO insuranceDTO) {
        return modelMapper.map(insuranceDTO, CarInsurance.class);
    }



}
