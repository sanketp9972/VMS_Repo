package com.app.service;

import com.app.dto.CarFinanceDTO;
import com.app.entity.CarFinance;
import com.app.repository.CarFinanceRepository;
import com.app.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarFinanceServiceImpl implements CarFinanceService {

	@Autowired
    private final CarFinanceRepository carFinanceRepository;
    

    @Autowired
    public CarFinanceServiceImpl(CarFinanceRepository carFinanceRepository) {
        this.carFinanceRepository = carFinanceRepository;
    }

    @Override
    public CarFinanceDTO createCarFinance(CarFinanceDTO carFinanceDTO) {

        CarFinance carFinance = new CarFinance();

        // Map fields from DTO to entity
        carFinance.setLoanAmount(carFinanceDTO.getLoanAmount());
        carFinance.setInterestRate(carFinanceDTO.getInterestRate());
        carFinance.setMonthlyPayment(carFinanceDTO.getMonthlyPayment());
        carFinance.setFinanceName(carFinanceDTO.getFinanceName());
        
        CarFinance savedCarFinance = carFinanceRepository.save(carFinance);
        return mapToDTO(savedCarFinance);
        
    }

    @Override
    public List<CarFinance> getAllCarFinances() {
       
        return carFinanceRepository.findAll();
    }

    @Override
    public CarFinanceDTO getCarFinanceById(Long financeId) {
        Optional<CarFinance> optionalCarFinance = carFinanceRepository.findById(financeId);
        return optionalCarFinance.map(this::mapToDTO).orElse(null);
    }

    @Override
    public CarFinanceDTO updateCarFinance(Long financeId, CarFinanceDTO carFinanceDTO) {
        Optional<CarFinance> optionalCarFinance = carFinanceRepository.findById(financeId);
        if (optionalCarFinance.isPresent()) {
            CarFinance carFinance = optionalCarFinance.get();
            // Update fields from DTO to entity
            carFinance.setLoanAmount(carFinanceDTO.getLoanAmount());
            carFinance.setInterestRate(carFinanceDTO.getInterestRate());
            carFinance.setMonthlyPayment(carFinanceDTO.getMonthlyPayment());
            carFinance.setFinanceName(carFinanceDTO.getFinanceName());

            CarFinance updatedCarFinance = carFinanceRepository.save(carFinance);
            return mapToDTO(updatedCarFinance);
        }
        return null;
    }

    @Override
    public void deleteCarFinance(Long financeId) {
        carFinanceRepository.deleteById(financeId);
    }

    private CarFinanceDTO mapToDTO(CarFinance carFinance) {
        return new CarFinanceDTO(
                
                carFinance.getLoanAmount(),
                carFinance.getInterestRate(),
                carFinance.getMonthlyPayment(),
                carFinance.getFinanceName()
        );
    }
}


