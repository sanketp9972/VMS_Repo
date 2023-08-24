import React, { useEffect, useState } from "react";
import "../../styles/insurance-list.css";
import axios from "axios";
import { useLocation } from "react-router-dom";

const InsuranceList = () => {

  const location = useLocation();
  const selectedCar = location.state?.car || {};

  const [insurance, setInsurance] = useState([]);
  const [selectedInsurance, setSelectedInsurance] = useState(null); // Track selected insurance
  const [finance, setFinance] = useState([]);
  const [selectedFinance, setSelectedFinance] = useState(null);


  // -----------------------------Load After Loading the page only Once--------------------------------
  useEffect(() => {
    loadInsurance();
    loadFinance();
  }, []);

  // --------------------------------------Insurance-------------------------------------------------
  const loadInsurance = () => {
    axios
      .get("http://localhost:6060/insurance")
      .then(function (response) {
        setInsurance(response.data);
        console.log(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  const handleInsuranceChange = (insuranceId) => {
    setSelectedInsurance(insuranceId);
    console.log("you have choose Insurance" + insuranceId);
  };

  // --------------------------------------Finance-------------------------------------------------
  const loadFinance = () => {

    axios
      .get("http://localhost:6060/finance")
      .then(function (response) {
        setFinance(response.data);
        console.log(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });

  };


  const handleFinanceChange = (financeId) => {
    setSelectedFinance(financeId);
    console.log("you have choose Finance = " + financeId);
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

        {/* --------------------------------------------------------------------- */}

      </div>

      <div className=" final">
       
      </div>


    </div>
  );
};

export default InsuranceList;
