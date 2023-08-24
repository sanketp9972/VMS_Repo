package com.app.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.CarServiceDTO;
import com.app.dto.CarServiceUpdateDTO;
import com.app.entity.CarServices;
import com.app.entity.Cars;
import com.app.repository.CarServicesRepository;
import com.app.repository.CarsRepository;

@Service
@Transactional
public class CarServicesServiceImpl implements CarServicesService{
	@Autowired
	private CarServicesRepository carSerRepo;
	
	@Autowired
	private CarsRepository carRepo;

	@Override
	public CarServices getServicesById(Long carId) {
		
		return carSerRepo.findById(carId).orElseThrow(() -> new ResourceNotFoundException("Car Not Found in CarServices "));
	}

	//For Users
	@Override
	public List<CarServices> getServices() {
		
		return carSerRepo.findAll();
	}

	//Insert a new Service 
	@Override
	public String addService(CarServiceDTO serviceDTO) {
		Cars car = carRepo.findById(serviceDTO.getCarId()).orElseThrow(() -> new ResourceNotFoundException("Car Not Found"));
		
		CarServices service = new CarServices();
		service.setServiceDate(serviceDTO.getServiceDate());
		service.setServiceName(serviceDTO.getServiceName());
		service.setDescription(serviceDTO.getDescription());
		service.setCar(car);
		car.getService().add(service);

        carSerRepo.save(service);
        carRepo.save(car);
		return "Service saved sucessfully";
	}
	
	
	//Update the new Service
	@Transactional
    public String updateService(Long carId, Long serviceId, CarServiceUpdateDTO serviceDTO) {
        Optional<CarServices> optionalService = carSerRepo.findById(serviceId);
        if (optionalService.isEmpty()) {
            return "Service not found";
        }

        CarServices service = optionalService.get();
        if (!service.getCar().getId().equals(carId)) {
            return "Service is not associated with the provided car";
        }

        service.setServiceDate(serviceDTO.getServiceDate());
        service.setServiceName(serviceDTO.getServiceName());
        service.setDescription(serviceDTO.getDescription());

        carSerRepo.save(service);

        return "Service updated successfully";
    }
	



}
