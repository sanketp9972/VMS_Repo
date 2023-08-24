package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarRequestDTO {
	private String brandName;
    private String modelName;
    private int year;
    private double price;
    private double mileage;
    private String fuelType;
    private String transmissionType;
    private String description;
    private CarSpecificationDTO CarSpec;
}
