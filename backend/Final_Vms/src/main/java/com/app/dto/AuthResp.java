package com.app.dto;

import java.time.LocalDate;

import com.app.entity.UserRoles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthResp {	
	private Long id;
	private String firstName;	
	private String lastName;		
	private String email;
	private String phone;
    private String address;
	private UserRoles userRoles;
}
