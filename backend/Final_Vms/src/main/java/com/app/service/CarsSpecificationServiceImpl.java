package com.app.service;

import com.app.dto.CarBookingDTO;
import com.app.dto.CarSpecificationDTO;
import com.app.dto.CarsDTO;
import com.app.dto.UsersDTO;
import com.app.entity.CarBooking;
import com.app.entity.Cars;
import com.app.entity.CarsSpecification;
import com.app.entity.Users;
import com.app.repository.CarsRepository;
import com.app.repository.CarsSpecificationRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class CarsSpecificationServiceImpl implements CarsSpecificationService {
    private final CarsSpecificationRepository specificationRepository;

    @Autowired
    public CarsSpecificationServiceImpl(CarsSpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }
    @Autowired
    public CarsRepository carRepository;
    
    @Autowired 
    public ModelMapper modelMapper;

    @Override
    public CarsSpecification addSpec(CarSpecificationDTO carsSpecificationDto) {
    
           CarsSpecification spec = convertToEntity(carsSpecificationDto);
            return specificationRepository.save(spec);
        }

    		 
    		 
//    @Override
//    public CarsSpecification addSpec(CarSpecificationDTO carSpecificationDTO)
//    {
//    	CarsSpecification carSpec = convertToEntity(carSpecificationDTO);
//    	return carRepository.save(carSpec);
//     }
    
  
    	
//    @Override
//    public CarBooking addBooking(CarBookingDTO bookingDTO) {
//        Optional<Cars> carOptional = carRepository.findById(bookingDTO.getCarId());
//        
//
//        if (carOptional.isPresent() && userOptional.isPresent()) {
//            CarBooking booking = new CarBooking();
//            booking.setBookingDate(LocalDate.now());
//            booking.setDeliveryDate(Date.from(bookingDTO.getDeliveryDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//            booking.setCar(carOptional.get());
//            booking.setUser(userOptional.get());
//            return carBookingRepository.save(booking);
//        }
//        return null;
//    }

    @Override
    public CarsSpecification getCarSpecificationById(Long id) {
        return specificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car specification not found with id: " + id));
    }

    @Override
    public List<CarsSpecification> getAllCarSpecifications() {
        return specificationRepository.findAll();
    }

    @Override
    public CarsSpecification updateCarsSpecification(Long id, CarSpecificationDTO  updatedSpec) {
    	Optional<CarsSpecification> specOptional = specificationRepository.findById(id);
    	if(specOptional != null)
    	{
    		 CarsSpecification existingSpec = specOptional.get();
    		 existingSpec.setColor(updatedSpec.getColor());
    	        existingSpec.setEngine(updatedSpec.getEngine());
    	        existingSpec.setHorsepower(updatedSpec.getHorsepower());
    	        existingSpec.setDimensions(updatedSpec.getDimensions());
//    	        existingSpec.setCarId(updatedSpec.getCarId());
    	        
    			
        	return specificationRepository.save(existingSpec);
    		
    	}
    	return null;
    }
    	
        

    
    
    
    @Override
    public void deleteCarSpecification(Long id) {
        specificationRepository.deleteById(id);
    }
    
    private CarsSpecification convertToEntity(CarSpecificationDTO carSpecificationDTO)
    {
    	return modelMapper.map(carSpecificationDTO, CarsSpecification.class);
    			
    }
    private CarSpecificationDTO convertToDto (CarsSpecification carsSpecification)
    {
    	return modelMapper.map(carsSpecification, CarSpecificationDTO.class);
    }
    

    
}
