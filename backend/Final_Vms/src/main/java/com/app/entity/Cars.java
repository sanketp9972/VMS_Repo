package com.app.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "cars")
	public class Cars extends BaseEntity {
		@Column(name = "brand_name", length = 50)
	    private String brandName;
		@Column(name = "model_name", length = 50)
	    private String modelName;
	    private int year;
	    private double price;
	    private double mileage;
	    @Column(name = "fuel_type", length = 50)
	    private String fuelType;
	    @Column(name = "transmission_type", length = 50)
	    private String transmissionType;
	    @Column(length = 150)
	    private String description;
	    
	    @Lob
	    private byte[] image;

	    @JsonIgnore
	    @LazyCollection(LazyCollectionOption.FALSE)
	    @JsonIgnoreProperties("car")
	    @OneToMany(mappedBy = "car" ,orphanRemoval = false)
	    private List<CarBooking> booking = new ArrayList<CarBooking>();
	    

	    @OneToOne( mappedBy = "car" , orphanRemoval = true, fetch = FetchType.EAGER)
	    private CarsSpecification carSpecification;
	    
        @JsonIgnore
	    @OneToMany(mappedBy = "cars" ,orphanRemoval = false)
	    private List<TestDrive> test =  new ArrayList<TestDrive>();
	    
	   
	  	@LazyCollection(LazyCollectionOption.FALSE)
	  	@JsonIgnore
	    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE, orphanRemoval = true)
	    private List<CarServices> service = new ArrayList<CarServices>();
	     
	    
	    public void addBooking(CarBooking book) {
	    	booking.add(book);
	    	book.setCar(this);
	    }
	    
	   
	    
		@Override
		public String toString() {
			return "Cars [ id()=" + getId() + ", brandName= " + brandName + ", modelName=" + modelName + ", year=" + year + ", price=" + price
					+ ", mileage=" + mileage + ", fuelType=" + fuelType + ", transmissionType=" + transmissionType
					+ ", description=" + description +  "]";
		}



		
	    
    
}
	

