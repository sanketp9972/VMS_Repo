package com.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import com.app.entity.PaymentStatus;

@Getter
@Setter
public class CarBookingDTO {
    private LocalDate deliveryDate;
    private Long carId;
    private Long userId;
    private Long insuranceId;
    private Long financeId;
    private PaymentStatus status;
}
