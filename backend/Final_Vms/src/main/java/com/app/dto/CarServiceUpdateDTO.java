package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarServiceUpdateDTO {

	private LocalDate serviceDate;
	private String serviceName;
	private String description;
}
