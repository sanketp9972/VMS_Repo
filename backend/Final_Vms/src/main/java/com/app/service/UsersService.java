package com.app.service;

import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.UsersDTO;
import com.app.dto.UsersPostDTO;
import com.app.entity.Users;

import java.util.List;

public interface UsersService {
    Users addUser(UsersPostDTO usersDTO);
    void deleteUser(Long userId);
    Users updateUser(Long userId, UsersDTO usersDTO);
    List<Users> findAllUsers();
    Users findUserById(Long userId);
    List<Users> findUsersByBookingCarId(Long carId);
    
  //add a method for emp signin
  	AuthResp authenticateEmp(AuthRequest request);
}
