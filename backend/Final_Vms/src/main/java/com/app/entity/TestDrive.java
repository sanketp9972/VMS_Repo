package com.app.entity;

import java.sql.Date;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


	@Setter
	@Getter
	@NoArgsConstructor
	@ToString
	@Entity
	@Table(name="testdrive")
	public class TestDrive {

			@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "testDrive_id")
		    private Long testDriveId;
		

		    @JsonIgnore
		    @ManyToOne
			@JoinColumn(name = "car_id", nullable = true)
			private Cars cars;
		    
		    
		    
		    @JsonIgnoreProperties("test")
		    @ManyToOne(fetch = FetchType.EAGER)
		    @JoinColumn(name = "user_id", nullable = false )
		    private Users user;
		    

		    @Column(name = "testdrive_date", nullable = false)
		    private LocalDate testDriveDate;
		    
		    private String comments;
			
			
		    public TestDrive(Cars cars, Users user, LocalDate testDriveDate, String comments) {
				super();
				this.cars = cars;
				this.user = user;
				this.testDriveDate = testDriveDate;
				this.comments = comments;
			}
		    
	
}
