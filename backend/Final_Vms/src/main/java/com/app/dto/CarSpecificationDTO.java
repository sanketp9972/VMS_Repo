package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarSpecificationDTO {
	
    private String color;
    private String engine;
    private double horsepower;
    private double dimensions;
//    private Long carId;

}