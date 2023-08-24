package com.app.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name= "Users")
public class Users {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false) // customizes col name
	private Long id;
	
    @Column(nullable = false)
    private String firstName;
    
    private String lastName;
    
    @Column(nullable = false , unique = true)
    private String email;
    
    @Column(nullable = false)
    private String phone;
    
    @Column(nullable = false)
    private String address;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoles userRoles;
    
    @Column(nullable = false , length = 25)
    private String password;
    
    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CarBooking> booking = new ArrayList<CarBooking>();


      @LazyCollection(LazyCollectionOption.FALSE)
	  @JsonIgnoreProperties(value = "cars")
	  @OneToMany(mappedBy = "user" ,orphanRemoval = true)
	  private List<TestDrive> test =  new ArrayList<TestDrive>();
     
 
}