import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
const CarDetails = () => {

  const { id } = useParams();
 
  const [carDetails, setCarDetails] = useState();

  useEffect(() => {
    fetchCarDetails(id);
  }, []);

  const fetchCarDetails = (id) => {
    debugger
    axios.get(`http://localhost:6060/cars/${id}`)
      .then(function (response) {
        setCarDetails(response.data);
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  return (
    <>
    <div className="Container">
      {carDetails && (
        <div>
          <h5>Brand Name: {carDetails.brandName}</h5>
          <h5>Model Name: {carDetails.modelName}</h5>
          <h5>Year: {carDetails.year}</h5>
          <h5>Price: ${carDetails.price}</h5>
          <h5>Mileage: {carDetails.mileage}</h5>
          <h5>Fuel Type: {carDetails.fuelType}</h5>
          <h5>Transmission Type: {carDetails.transmissionType}</h5>
          <p>Description: {carDetails.description}</p>
        </div>
      )}
    </div>
    </>
  );
};

export default CarDetails;
