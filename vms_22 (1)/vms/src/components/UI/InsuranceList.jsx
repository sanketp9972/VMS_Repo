import React, { useEffect, useState } from "react";
import "../../styles/insurance-list.css";
import axios from "axios";
import { useLocation } from "react-router-dom";
import { createUrl, log } from '../../utils/utils';
import { toast } from 'react-toastify';

const InsuranceList = () => {

  const location = useLocation();
  const selectedCar = location.state?.car || {};

  const userId = 1;


  //Insurance and Finance
  const [insurance, setInsurance] = useState([]);
  const [selectedInsurance, setSelectedInsurance] = useState(null); // Track selected insurance
  const [finance, setFinance] = useState([]);
  const [selectedFinance, setSelectedFinance] = useState(null);

  //Paymet states
  const [paymentSuccessful, setPaymentSuccessful] = useState(false);
  const [selectedPaymentOption, setSelectedPaymentOption] = useState("");
  const [showPaymentPending, setShowPaymentPending] = useState(false);
  const [selectedInsuranceError, setSelectedInsuranceError] = useState(false);

  const [selectedDeliveryDate, setSelectedDeliveryDate] = useState(null); // Add state for selected date


  // -----------------------------Load After Loading the page only Once--------------------------------
  useEffect(() => {
    loadInsurance();
    loadFinance();
  }, []);

  // --------------------------------------Insurance-------------------------------------------------
  const loadInsurance = () => {
    const url = createUrl(`/insurance`);
    axios
      .get(url)
      .then(function (response) {
        setInsurance(response.data);
        log(response.data);
      })
      .catch(function (error) {
        log(error);
      });
  };

  const handleInsuranceChange = (insuranceId) => {
    setSelectedInsurance(insuranceId);
    console.log("you have choose Insurance" + insuranceId);
  };

  // --------------------------------------Finance-------------------------------------------------
  const loadFinance = () => {
    const url = createUrl(`/finance`);
    axios
      .get(url)
      .then(function (response) {
        setFinance(response.data);
        log(response.data);
      })
      .catch(function (error) {
        log(error);
      });

  };


  const handleFinanceChange = (financeId) => {
    setSelectedFinance(financeId);
    log("you have choose Finance = " + financeId);
  }


  const handleSubmit = (event) => {
    event.preventDefault();

    if (!selectedInsurance) {
      setSelectedInsuranceError(true);
      return;
    } else {
      setSelectedInsuranceError(false);
    }

    if (selectedPaymentOption === "cardPayment") {
      // setPaymentSuccessful(true);
      // setShowPaymentPending(false);
      toast.success("Payment Sucessful")
    } else if (selectedPaymentOption === "cashPayment") {
      // setShowPaymentPending(true);
      // setPaymentSuccessful(false); // Reset payment successful status for cash payment
      toast.info("Payment pending , select COD")
    }

    setSelectedFinance(null);
    setSelectedDeliveryDate(null);
    setSelectedInsurance(null);
    setSelectedPaymentOption("");
  };




  //-----------------------Make A post request for user can book the car ---------------------------------
  const BookCar = () => {
    if (!selectedInsurance || !selectedFinance || !selectedDeliveryDate) {
      // Check if all required data is selected before making the booking
      console.log("Please select insurance, finance, and delivery date.");
      return;
    }

    const bookingData = {
      insuranceId: selectedInsurance,
      financeId: selectedFinance,
      deliveryDate: selectedDeliveryDate,
      carId: selectedCar.id,
      userId: userId
    };

    const url = createUrl(`/bookings`);
    axios
      .post(url, bookingData)
      .then(function (response) {
        console.log("Booking successful:", response.data);
        // You might want to set some state here to indicate successful booking
      })
      .catch(function (error) {
        console.log("Booking error:", error);
        toast.success("Payment Failure")
      });
  }


  return (
    <div className="container">
      <div className="abc">
        <center> <h1>You Have Chosen {selectedCar.brandName}    {selectedCar.modelName}</h1></center>
        <h2 className="topic">Select Insurance</h2> <br /> <br />

        <div className="col-md-6">
          <table className="table table-bordered table-hover text align-center">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Insurance_Provider</th>
                <th scope="col">Premium Amount</th>
                <th scope="col">Year</th>
                <th scope="col">Select</th>
              </tr>
            </thead>
            <tbody>
              {insurance.map((data) => (
                <tr key={data.insuranceId}>
                  <td>{data.insuranceId}</td>
                  <td>{data.insuranceProvider}</td>
                  <td>{data.premiumAmt}</td>
                  <td>{data.year}</td>
                  <td>
                    <input
                      type="radio"
                      name="insurance"
                      value={data.insuranceId}
                      checked={selectedInsurance === data.insuranceId}
                      onChange={() => handleInsuranceChange(data.insuranceId)}

                    />
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        {/* //-------------------------------------------------------------------------------------------------------// */}
        <h2 className="topic">Select Finance</h2>
        <br /> <br />

        <div className="col-md-6">
          <table className="table table-bordered table-hover">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Finance Name</th>
                <th scope="col">Loan Amount</th>
                <th scope="col">Interest Rate</th>
                <th scope="col">Select</th>
              </tr>
            </thead>
            <tbody>
              {finance.map((data) => (
                <tr key={data.financeId}>
                  <td>{data.financeId}</td>
                  <td>{data.financeName}</td>
                  <td>{data.loanAmount}</td>
                  <td>{data.interestRate}</td>
                  <td>
                    <input
                      type="radio"
                      name="finance"
                      value={data.financeId}
                      checked={selectedFinance === data.financeId}
                      onChange={() => handleFinanceChange(data.financeId)}

                    />
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        {/* ----------------------------------Delevery Date ------------------------------ */}

        <h2 className="topic">Select Delivery Date</h2>


        <div className="row">


          <div className="col">
            <form>
              <div className="mb-3">
                <label htmlFor="deliveryDate" className="form-label">Delivery Date:</label>
                <input
                  type="date"
                  className="form-control"
                  id="deliveryDate"
                  name="deliveryDate"
                  value={selectedDeliveryDate}
                  onChange={(e) => setSelectedDeliveryDate(e.target.value)}
                  required
                />
              </div>
            </form>
          </div>
          <div className="col"></div>
          <div className="col"></div>
        </div>

        {/* ------------------------------- Payment -------------------------------------- */}

        <h2 className="topic">Enter Payment Details</h2>
        <br /> <br />
        <label>
          <input
            type="radio"
            name="options"
            value="cardPayment"
            checked={selectedPaymentOption === "cardPayment"}
            onChange={() => setSelectedPaymentOption("cardPayment")}
          />
          Card Payment
        </label>
        <br />
        <label>
          <input
            type="radio"
            name="options"
            value="cashPayment"
            checked={selectedPaymentOption === "cashPayment"}
            onChange={() => setSelectedPaymentOption("cashPayment")}
          />
          Cash Payment
        </label>
        <br /><br />
        <div className="container">
          <div className="row justify-content-left">
            <div className="col-md-6">
              {selectedPaymentOption === "cashPayment" ? (
                <div>
                  <button
                    className="btn btn-primary"
                    // onClick={() => {
                    //   setPaymentSuccessful(false);
                    //   setShowPaymentPending(true);
                    // }}
                    onClick={BookCar}
                    disabled={!selectedInsurance}
                  >
                    Payment
                  </button>
                  {/* {showPaymentPending && <p className="text-warning mt-3">Payment Pending, pay on delivey</p>} */}

                </div>
              ) : (
                <form onSubmit={handleSubmit}>
                  <div className="mb-3">
                    <label htmlFor="cardNumber" className="form-label">Card Number:</label>
                    <input
                      type="text"
                      className="form-control"
                      id="cardNumber"
                      name="cardNumber"

                      placeholder="Enter card number"
                      maxLength="16"
                      required
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="cvv" className="form-label">CVV:</label>
                    <input
                      type="password"
                      className="form-control"
                      id="cvv"
                      name="cvv"
                      placeholder="Enter CVV"
                      maxLength="3"
                      required
                    />
                  </div>
                  <button type="submit" onClick={BookCar} className="btn btn-primary" disabled={!selectedInsurance}>
                    Payment
                  </button>
                  {/* {paymentSuccessful && <p className="text-success mt-3">Payment Successful</p>} */}
                </form>
              )}
            </div>
          </div>
        </div>
      </div>

    </div>



  );
};

export default InsuranceList;