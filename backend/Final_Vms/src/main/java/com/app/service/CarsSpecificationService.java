package com.app.service;

import com.app.dto.CarSpecificationDTO;
import com.app.dto.UsersDTO;
import com.app.entity.CarsSpecification;


import java.util.List;

public interface CarsSpecificationService {
	 
    CarsSpecification addSpec(CarSpecificationDTO carsSpecificationDto);
    CarsSpecification getCarSpecificationById(Long id);
    List<CarsSpecification> getAllCarSpecifications();
    CarsSpecification updateCarsSpecification(Long id, CarSpecificationDTO carsSpecificationDto);
    void deleteCarSpecification(Long id);
}