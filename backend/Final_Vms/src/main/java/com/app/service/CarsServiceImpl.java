package com.app.service;

import com.app.dto.CarRequestDTO;
import com.app.dto.CarSpecificationDTO;
import com.app.dto.CarsDTO;
import com.app.entity.Cars;
import com.app.entity.CarBooking;
import com.app.entity.TestDrive;
import com.app.entity.CarsSpecification;
import com.app.repository.CarsRepository;
import com.app.repository.CarsSpecificationRepository;
import com.app.service.CarsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepository carsRepository;
    
    @Autowired
    private CarsSpecificationRepository carSpecRepository;
    
    @Autowired
    private ModelMapper modelMapper;


        public Cars createCar(CarRequestDTO carRequestDTO) {
            // Create a Car entity
            Cars car = new Cars();
            car.setBrandName(carRequestDTO.getBrandName());
            car.setDescription(carRequestDTO.getDescription());
            car.setFuelType(carRequestDTO.getFuelType());
            car.setMileage(carRequestDTO.getMileage());
            car.setModelName(carRequestDTO.getModelName());
            car.setPrice(carRequestDTO.getPrice());
            car.setTransmissionType(carRequestDTO.getTransmissionType());
            car.setYear(carRequestDTO.getYear());

            // Create a CarSpec entity
            CarSpecificationDTO carSpecDTO = carRequestDTO.getCarSpec();
            CarsSpecification carSpec = new CarsSpecification();
            carSpec.setColor(carSpecDTO.getColor());
            carSpec.setDimensions(carSpecDTO.getDimensions());
            carSpec.setEngine(carSpecDTO.getEngine());
            carSpec.setHorsepower(carSpecDTO.getHorsepower());

            // Establish the one-to-one relationship
            car.setCarSpecification(carSpec);
            carSpec.setCar(car);

            // Save both entities
            carsRepository.save(car);
            carSpecRepository.save(carSpec);

            return car;
        }
    


//    @Override
//    public void deleteCar(Long carId) {
//        carsRepository.deleteById(carId);
//    }
        
        @Override
        @Transactional
        public void deleteCar(Long carId) {
            Cars car = carsRepository.findById(carId).orElse(null);
            
            if (car != null) {
                // Remove the association from CarBooking entities
                for (CarBooking booking : car.getBooking()) {
                    booking.setCar(null);
                }
                for (TestDrive test : car.getTest()) {
                	test.setCars(null);
                }
                // Delete the Cars entity
                carsRepository.deleteById(carId);
            }
        }
    
    
    @Override
    @Transactional
    public Cars updateCar(Long carId, CarRequestDTO carRequestDTO) {
        Cars existingCar = carsRepository.findById(carId).orElse(null);

        if (existingCar != null) {
            // Update Car entity
            existingCar.setBrandName(carRequestDTO.getBrandName());
            existingCar.setDescription(carRequestDTO.getDescription());
            existingCar.setFuelType(carRequestDTO.getFuelType());
            existingCar.setMileage(carRequestDTO.getMileage());
            existingCar.setModelName(carRequestDTO.getModelName());
            existingCar.setPrice(carRequestDTO.getPrice());
            existingCar.setTransmissionType(carRequestDTO.getTransmissionType());
            existingCar.setYear(carRequestDTO.getYear());

            // Update CarSpec entity
            CarSpecificationDTO carSpecDTO = carRequestDTO.getCarSpec();
            CarsSpecification carSpec = existingCar.getCarSpecification();
            if (carSpec != null) {
                carSpec.setColor(carSpecDTO.getColor());
                carSpec.setDimensions(carSpecDTO.getDimensions());
                carSpec.setEngine(carSpecDTO.getEngine());
                carSpec.setHorsepower(carSpecDTO.getHorsepower());
            }

            return carsRepository.save(existingCar);
        }

        return null;
    }
    
    @Override
    public Cars findCarById(Long carId) {
        return carsRepository.findById(carId).orElse(null);
    }

  
    @Override
    public Cars findCarWithSpecificationById(Long carId) {
        return carsRepository.findCarWithSpecificationById(carId);
    }

    @Override
    public Optional<Cars> getCarByBrandAndModelWithSpec(String brandName, String modelName) {
        return carsRepository.findCarByBrandAndModelWithSpec(brandName, modelName);
    }

    private Cars convertToEntity(CarsDTO carsDTO) {
        return modelMapper.map(carsDTO, Cars.class);
    }

    private CarsDTO convertToDTO(Cars car) {
        return modelMapper.map(car, CarsDTO.class);
    }

    @Override
    public List<Cars> getAllCarsWithSpec2() {
        return carsRepository.findAllByCarSpecificationIsNotNull();
    }

    @Override
    public List<Cars> getAllCarsWithoutSpec2() {
        return carsRepository.findAllByCarSpecificationIsNull();
    }
    
    @Override
    public List<Cars> getCarDetailsByBrandOrModel(String brandName, String modelName) {
        return carsRepository.findByBrandNameOrModelName(brandName, modelName);
    }
    
    

}

