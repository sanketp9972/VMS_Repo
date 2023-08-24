package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestDriveUpdateDTO {

	private LocalDate testDriveDate;
    private String comments;
	
}
