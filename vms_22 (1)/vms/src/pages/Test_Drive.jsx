import React, { useState } from 'react';

const TestDrivePage = () => {
  const [selectedCar, setSelectedCar] = useState(null);
  const [fullName, setFullName] = useState('');
  const [phone, setPhone] = useState('');
  const [email, setEmail] = useState('');
  const [submitted, setSubmitted] = useState(false);

  const cars = [
    { id: 1, name: 'Car 1' },
    { id: 2, name: 'Car 2' },
    { id: 3, name: 'Car 3' },
  ];

  const handleCarChange = (event) => {
    const carId = parseInt(event.target.value);
    const car = cars.find((car) => car.id === carId);
    setSelectedCar(car);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Here you can handle the form submission, e.g., make an API request to save the test drive request
    setSubmitted(true);
  };

  return (
    <div>
      <h2>Test Drive Page</h2>
      {submitted ? (
        <p>Thank you for requesting a test drive. We will contact you shortly.</p>
      ) : (
        <form onSubmit={handleSubmit}>
          <div>
            <label>Car:</label>
            <select onChange={handleCarChange} required>
              <option value="">Select a car</option>
              {cars.map((car) => (
                <option key={car.id} value={car.id}>
                  {car.name}
                </option>
              ))}
            </select>
          </div>

          <div>
            <label>Full Name:</label>
            <input type="text" value={fullName} onChange={(e) => setFullName(e.target.value)} required />
          </div>

          <div>
            <label>Phone Number:</label>
            <input type="tel" value={phone} onChange={(e) => setPhone(e.target.value)} required />
          </div>

          <div>
            <label>Email:</label>
            <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
          </div>

          <button type="submit">Request Test Drive</button>
        </form>
      )}
    </div>
  );
};

export default TestDrivePage;
