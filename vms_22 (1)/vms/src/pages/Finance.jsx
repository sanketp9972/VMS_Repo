import React, { useState } from 'react';

const FinancePage = () => {
  const [selectedCar, setSelectedCar] = useState(null);
  const [loanAmount, setLoanAmount] = useState(0);
  const [insuranceAmount, setInsuranceAmount] = useState(0);
  const [emi, setEMI] = useState(0);

  const cars = [
    { id: 1, name: 'Car 1', price: 20000 },
    { id: 2, name: 'Car 2', price: 25000 },
    { id: 3, name: 'Car 3', price: 30000 },
  ];

  const handleCarChange = (event) => {
    const carId = parseInt(event.target.value);
    const car = cars.find((car) => car.id === carId);
    setSelectedCar(car);
    setLoanAmount(0);
    setInsuranceAmount(0);
    setEMI(0);
  };

  const handleLoanChange = (event) => {
    const loanAmount = parseInt(event.target.value);
    setLoanAmount(loanAmount);
    calculateEMI(loanAmount, insuranceAmount);
  };

  const handleInsuranceChange = (event) => {
    const insuranceAmount = parseInt(event.target.value);
    setInsuranceAmount(insuranceAmount);
    calculateEMI(loanAmount, insuranceAmount);
  };

  const calculateEMI = (loanAmount, insuranceAmount) => {
    // Calculate EMI based on loanAmount and insuranceAmount
    const emi = (loanAmount + insuranceAmount) / 12;
    setEMI(emi);
  };

  return (
    <div>
      <h2 style={{color : 'red'}}>Finance Page</h2>

      <h3>Car Selection</h3>
      <select onChange={handleCarChange}>
        <option value="">Select a car</option>
        {cars.map((car) => (
          <option key={car.id} value={car.id}>
            {car.name} - ${car.price}
          </option>
        ))}
      </select>

      <center>
        {selectedCar && (
          <div className='common'>
            <div className='loan'>
              <h5>Loan for {selectedCar.name}</h5>
              <input
                type="number"
                placeholder="Loan amount"
                value={loanAmount}
                onChange={handleLoanChange}
              />
            </div>

            <div className='insurance'>
              <h5>Insurance for {selectedCar.name}</h5>
              <input
                type="number"
                placeholder="Insurance amount"
                value={insuranceAmount}
                onChange={handleInsuranceChange}
              />
            </div>

            <h4>Monthly EMI: ${emi}</h4>
          </div>
        )}
      </center>
    </div>
  );
};

export default FinancePage;
