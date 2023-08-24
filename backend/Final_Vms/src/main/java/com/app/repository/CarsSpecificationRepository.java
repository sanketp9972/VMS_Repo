package com.app.repository;

import com.app.entity.CarBooking;
import com.app.entity.CarsSpecification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsSpecificationRepository extends JpaRepository<CarsSpecification, Long> {
    // You can add custom query methods here if needed
//	 List<CarsSpecification> findByCarId(Long carId);
}
