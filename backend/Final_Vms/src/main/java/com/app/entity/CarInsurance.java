package com.app.entity;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="insurance")
public class CarInsurance {
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long insuranceId;


@Column(name = "insurance_provider", length = 50)
private String insuranceProvider;

@Column(name="policy_no")
private Long policyNumber;

@Column(name="premiun_amt")
private double premiumAmt;

@Column(name="claim_amt")
private double claimAmt;

private Long year;
@Enumerated(EnumType.STRING)
private InsuranceMode mode;

//
//@OneToOne( mappedBy = "user" , orphanRemoval = false, fetch = FetchType.EAGER)
//private CarBooking booking;

}

//insuranceProvider;
//private Long policyNumber;
//private double premiumAmt;
//private double claimAmt;
//private Long year;
//private InsuranceMode mode;


