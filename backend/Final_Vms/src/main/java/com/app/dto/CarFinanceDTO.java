package com.app.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class CarFinanceDTO {
	//private Long financeId;
    private double loanAmount;
	private double interestRate;
    private double monthlyPayment;
    private String financeName;
    
    
    public CarFinanceDTO(double loanAmount, double interestRate, double monthlyPayment, String financeName) {
		
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.monthlyPayment = monthlyPayment;
		this.financeName = financeName;
	}
}
