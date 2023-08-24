package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.CarInsurance;

@Repository
public interface CarInsuranceRepository extends JpaRepository<CarInsurance, Long> {

}
