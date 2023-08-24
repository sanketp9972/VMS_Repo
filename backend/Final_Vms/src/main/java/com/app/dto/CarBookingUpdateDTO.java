package com.app.dto;

import java.time.LocalDate;

import com.app.entity.PaymentStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarBookingUpdateDTO {
	
	private LocalDate deliveryDate;
	private PaymentStatus status;

}
