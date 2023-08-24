package com.app.controller;

import com.app.dto.CarBookingDTO;
import com.app.entity.CarBooking;
import com.app.service.CarBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "http://localhost:3000")
public class CarBookingController {

    @Autowired
    private CarBookingService carBookingService;

    @PostMapping
    public ResponseEntity<CarBooking> addBooking(@RequestBody CarBookingDTO bookingDTO) {
        CarBooking addedBooking = carBookingService.addBooking(bookingDTO);
        if (addedBooking != null) {
            return new ResponseEntity<>(addedBooking, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<CarBooking>> getBookingsByUserId(@PathVariable Long userId) {
        List<CarBooking> bookings = carBookingService.getBookingsByUserId(userId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/by-car/{carId}")
    public ResponseEntity<List<CarBooking>> getBookingsByCarId(@PathVariable Long carId) {
        List<CarBooking> bookings = carBookingService.getBookingsByCarId(carId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarBooking>> getAllBookings() {
        List<CarBooking> bookings = carBookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<CarBooking> updateBooking(@PathVariable Long bookingId, @RequestBody CarBookingDTO bookingDTO) {
        CarBooking updatedBooking = carBookingService.updateBooking(bookingId, bookingDTO);
        if (updatedBooking != null) {
            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
//    @PutMapping("/{bookingId}")
//    public ResponseEntity<CarBooking> updateBooking(@PathVariable Long bookingId, @RequestBody CarBookingDTO bookingDTO,CarBooking carbook){
//    	carBookingService.getBookingById(carbook.getId());
//    	carBookingService.addBooking(bookingDTO);
//    	return addBooking(bookingDTO);
//    }
//   
    
    
//    @PutMapping("/{bookingId}")
//    public CarBooking updateBooking(@RequestBody CarBookingDTO detachedBooking , CarBooking carbook)
//    {
//    	System.out.println("In Update "+carbook.getId());
//    	
//    	carBookingService.getBookingById(carbook.getId());
//    	carBookingService.addBooking(detachedBooking);
//    	
//    	return carBookingService.addBooking(detachedBooking);
//    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
        carBookingService.deleteBooking(bookingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<CarBooking> getBookingById(@PathVariable Long bookingId) {
        CarBooking booking = carBookingService.getBookingById(bookingId);
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
