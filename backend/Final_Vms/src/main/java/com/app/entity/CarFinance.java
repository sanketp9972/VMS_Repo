package com.app.entity;

import javax.persistence.*;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="finance")
public class CarFinance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long financeId;
	
	@Column(name = "loan_amount", nullable = false)
	private double loanAmount;
	
	@Column(name = "interest_rate", nullable = false)
	private double interestRate;
	
	@Column(name = "monthly_payment", nullable = false)
	private double monthlyPayment;
	
	@Column(name = "finance_name", nullable = false)
	private String financeName;

//	 @OneToOne( orphanRemoval = false, fetch = FetchType.EAGER)
//	 private CarBooking booking;
//	

}
