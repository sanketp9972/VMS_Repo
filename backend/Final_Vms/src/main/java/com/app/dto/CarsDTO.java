package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import com.app.entity.CarsSpecification;

@Getter
@Setter
public class CarsDTO {
    private String brandName;
    private String modelName;
    private int year;
    private double price;
    private double mileage;
    private String fuelType;
    private String transmissionType;
    private String description;
//    private List<Long> bookingIds; // Assuming you want to fetch booking IDs
    private Long specificationId;
    private CarSpecificationDTO specification;
}
