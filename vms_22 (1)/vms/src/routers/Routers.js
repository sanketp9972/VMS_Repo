import React from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import Home from "../pages/Home";
import About from "../pages/About";
import CarListing from "../pages/CarListing";
import CarDetails from "../components/UI/CarDetails";
import NotFound from "../pages/NotFound";
import Contact from "../pages/Contact";
import FinancePage from "../pages/Finance";
import Services from "../pages/Services";
import TestDrivePage from "../pages/Test_Drive";
import Login from "../Authentication/Login";
import InsuranceList from "../components/UI/InsuranceList";
import RegisterUser from "../Authentication/Registration";

const Routers = () => {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/home" />} />
      <Route path="/home" element={<Home />} />
      <Route path="/about" element={<About />} />
      <Route path="/cars" element={<CarListing />} />
      <Route path="/carDetails/:id" element={<CarDetails />} />
      <Route path="/finance" element={<FinancePage />}/>
      <Route path="/services" element={< Services/>}/>   
      <Route path="/test-drive" element={<TestDrivePage/>}/>
      <Route path="/contact" element={<Contact />} />
      <Route path="*" element={<NotFound />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<RegisterUser />} />
      <Route path="/insurance/:id" element={<InsuranceList />} />
    </Routes>
  );
};

export default Routers;
