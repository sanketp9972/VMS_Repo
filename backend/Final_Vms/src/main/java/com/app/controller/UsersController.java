package com.app.controller;

import com.app.dto.AuthRequest;
import com.app.dto.UsersDTO;
import com.app.dto.UsersPostDTO;
import com.app.entity.Users;
import com.app.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<Users> addUser(@RequestBody UsersPostDTO usersPostDTO) {
        Users addedUser = usersService.addUser(usersPostDTO);
        return ResponseEntity.ok(addedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        usersService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Users> updateUser(@PathVariable Long userId, @RequestBody UsersDTO usersDTO) {
        Users updatedUser = usersService.updateUser(userId, usersDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable Long userId) {
        Users user = usersService.findUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/signIn")
	public ResponseEntity<?> authenticateEmp(@RequestBody @Valid AuthRequest request) {
		System.out.println("in sign in " + request);

		return new ResponseEntity<>(usersService.authenticateEmp(request), HttpStatus.OK);

	}

    @GetMapping("/by-booking/{carId}")
    public ResponseEntity<List<Users>> getUsersByBookingCarId(@PathVariable Long carId) {
        List<Users> users = usersService.findUsersByBookingCarId(carId);
        return ResponseEntity.ok(users);
    }
}
