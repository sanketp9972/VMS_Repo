package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CarServiceDTO {

	private LocalDate serviceDate;
	private String serviceName;
	private String description;
	private Long carId;
}
