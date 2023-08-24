package com.app.dto;


import com.app.entity.InsuranceMode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class InsuranceDTO {
	
private String insuranceProvider;
private Long policyNumber;
private double premiumAmt;
private double claimAmt;
private Long year;
private InsuranceMode mode;

}
