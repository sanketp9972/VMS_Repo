package com.app.entity;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class CarBooking {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id", nullable = false) // customizes col name
	private Long id;
     
         
	@Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;
          
    @Column(name = "delivery_date", nullable = false)
    private Date deliveryDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name= "payment_status", nullable = false)
    private PaymentStatus status;
    
    @JsonIgnoreProperties("booking")
	//@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
	@JoinColumn(name = "car_id", nullable = true)
	private Cars car;
    
    @JsonIgnoreProperties("test")
//  @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false )
    private Users user;
  
    
    @OneToOne
    private CarInsurance insurance;
    
   
    @OneToOne
    private CarFinance finance;

    
    public CarBooking(LocalDate bookingDate, Date deliveryDate, Cars car, Users user) {
        this.bookingDate = bookingDate;
        this.deliveryDate = deliveryDate;
        this.car = car;
        this.user = user;
    }
}
