package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.dto.TestDriveDTO;
import com.app.dto.TestDriveUpdateDTO;
import com.app.entity.*;
import com.app.repository.CarsRepository;
import com.app.repository.TestDriveRepository;
import com.app.service.TestDriveService;
@Controller
@RestController
@RequestMapping("/testdrive")
@CrossOrigin(origins = "http://localhost:3000")
public class TestDriveController {

	@Autowired
	private TestDriveService testDriveService;

	
	 @PostMapping
	    public ResponseEntity<TestDrive> addBooking(@RequestBody TestDriveDTO testDriveDTO) {
	        TestDrive bookTestDrive = testDriveService.addTestDrive(testDriveDTO);
	        if (bookTestDrive != null) {
	            return new ResponseEntity<>(bookTestDrive, HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }

	 @GetMapping
	 public ResponseEntity<List<TestDrive>> getAllTestDrives(){
		 List<TestDrive> testdrives = testDriveService.getAllTestDrives();
	        return new ResponseEntity<>(testdrives, HttpStatus.OK);
	 }

    @DeleteMapping("/{testDriveId}")
    public ResponseEntity<Void> deleteTestDrive(@PathVariable Long testDriveId) {
        testDriveService.deleteTestDrive(testDriveId);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{testDriveId}")
    public ResponseEntity<TestDrive> updateBooking(@PathVariable Long testDriveId, @RequestBody TestDriveUpdateDTO testDriveUpdateDTO) {
        TestDrive updatedTestDrive = testDriveService.updateTestDrive(testDriveId, testDriveUpdateDTO);
        if (updatedTestDrive != null) {
            return new ResponseEntity<>(updatedTestDrive, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}
