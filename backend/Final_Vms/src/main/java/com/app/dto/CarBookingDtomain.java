package com.app.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarBookingDtomain {
	
	
	private LocalDate bookingDate;
	
	private Date deliveryDate;
	
}
