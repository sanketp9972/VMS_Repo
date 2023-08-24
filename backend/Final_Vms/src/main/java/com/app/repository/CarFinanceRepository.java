package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CarFinance;

public interface CarFinanceRepository extends JpaRepository<CarFinance, Long> {

}
