package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestDriveDTO {

	private Long userId;
    private Long carId;
    private LocalDate testDriveDate;
    private String comments;

}
