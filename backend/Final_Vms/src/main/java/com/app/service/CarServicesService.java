
package com.app.service;

import java.util.List;

import com.app.dto.CarServiceDTO;
import com.app.dto.CarServiceUpdateDTO;
import com.app.entity.CarServices;

public interface CarServicesService {
	
	//get the services by carId
	CarServices getServicesById(Long carId);
	
	//get all carServices
	List<CarServices> getServices();

	String addService(CarServiceDTO serviceDTO);
	
	String updateService(Long carId, Long serviceId, CarServiceUpdateDTO serviceDTO);

}
