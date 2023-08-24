
package com.app.service;

import com.app.dto.CarFinanceDTO;
import com.app.entity.CarFinance;

import java.util.List;

public interface CarFinanceService {
    CarFinanceDTO createCarFinance(CarFinanceDTO carFinanceDto);
    List<CarFinance> getAllCarFinances();
    CarFinanceDTO getCarFinanceById(Long financeId);
    CarFinanceDTO updateCarFinance(Long financeId, CarFinanceDTO carFinanceDto);
    void deleteCarFinance(Long financeId);
}

