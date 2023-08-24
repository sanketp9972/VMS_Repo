package com.app.service;

import java.sql.Date;
import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.ZoneId;
//import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.TestDriveDTO;
import com.app.dto.TestDriveUpdateDTO;
import com.app.entity.CarBooking;
import com.app.entity.Cars;
import com.app.entity.TestDrive;
import com.app.entity.Users;
import com.app.repository.CarsRepository;
import com.app.repository.TestDriveRepository;
import com.app.repository.UsersRepository;


@Service
@Transactional
public class TestDriveServiceImpl implements TestDriveService {
	private  ModelMapper modelMapper;

	public TestDriveServiceImpl() {
		this.modelMapper = new ModelMapper();
	}
	
	@Autowired
	private TestDriveRepository testDriveRepo;	
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private CarsRepository carRepository;

	
	@Override
	public TestDrive addTestDrive(TestDriveDTO testDriveDTO) {
		Optional<Cars> carOptional = carRepository.findById(testDriveDTO.getCarId());
        Optional<Users> userOptional = userRepository.findById(testDriveDTO.getUserId());
        if (carOptional.isPresent() && userOptional.isPresent()) {
        	TestDrive testDrive = new TestDrive();
        	testDrive.setCars(carOptional.get());
        	testDrive.setUser(userOptional.get());
        //	testDrive.setTestDriveDate(LocalDate.from(testDriveDTO.getTestDriveDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        	testDrive.setTestDriveDate(testDriveDTO.getTestDriveDate());
        	testDrive.setComments(testDriveDTO.getComments());
        	return testDriveRepo.save(testDrive);
        }
        
		return null;
	}
	
	@Override
	public List<TestDrive> getAllTestDrives(){
		System.out.println(testDriveRepo.toString());
		return testDriveRepo.findAll();
	}

	@Override
	public void deleteTestDrive(Long testDriveId) {	
		testDriveRepo.deleteById(testDriveId);
	}	

	@Override
	public TestDrive updateTestDrive(Long testDriveId, TestDriveUpdateDTO testDriveUpdateDTO) {
		// TODO Auto-generated method stub
		Optional<TestDrive> testDriveOptional = testDriveRepo.findById(testDriveId); 
        if(testDriveOptional != null)
        {
        	TestDrive testDrive = testDriveOptional.get();
   //     	testDrive.setDeliveryDate(Date.from(testDriveDTO.getTestDriveDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        	testDrive.setTestDriveDate(testDriveUpdateDTO.getTestDriveDate());
        	testDrive.setComments(testDriveUpdateDTO.getComments());
        	return testDriveRepo.save(testDrive);
        }
        return null;
   
	}
	
}

