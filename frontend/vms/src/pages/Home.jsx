import React, { useEffect, useState } from "react";

import HeroSlider from "../components/UI/HeroSlider";
import Helmet from "../components/Helmet/Helmet";

import { Container, Row, Col } from "reactstrap";
import AboutSection from "../components/UI/AboutSection";
import ServicesList from "../components/UI/ServicesList";
import CarItem from "../components/UI/CarItem";
import axios from "axios";

const Home = () => {

   const [cars, setCars] = useState([]); 
  // const [imageData, setImageData] = useState(null);

  useEffect( () => {
    loadCars();
    // fetchImage();
  }, []);

  const loadCars = () => {
    debugger
    axios.get('http://localhost:6060/cars')
    .then(function (response) {
      setCars(response.data);
      console.log(response);
    })
    .catch(function (error) {
      
      console.log(error);
    })
    .finally(function () {
     
    });
  }

//   const fetchImage = async () => {
//     try {
//         const response = await fetch(`http://localhost:6060/cars/images/${item.id}`);
//         if (response.ok) {
//             const imageBlob = await response.blob();
//             const imageUrl = URL.createObjectURL(imageBlob);
//             setImageData(imageUrl);
//         } else {
//             console.error('Failed to fetch image');
//         }
//     } catch (error) {
//         console.error('Error fetching image:', error);
//     }
// };




  return (
    <Helmet title="Home">
      {/* ============= hero section =========== */}
      <section className="p-0 hero__slider-section">
        <HeroSlider />
      </section>
      {/* =========== about section ================ */}
      <AboutSection />
      {/* ========== services section ============ */}
      <section>
        <Container>
          <Row>
            <Col lg="12" className="mb-5 text-center">
              <h6 className="section__subtitle">See our</h6>
              <h2 className="section__title">Popular Services</h2>
            </Col>

            <ServicesList />
          </Row>
        </Container>
      </section>
      {/* =========== car offer section ============= */}
      <section>
        <Container>
          <Row>
            <Col lg="12" className="text-center mb-5">
              <h6 className="section__subtitle">Come with</h6>
              <h2 className="section__title">Hot Offers</h2>
            </Col>

            {cars.slice(0, 6).map((item) => (
              <CarItem item={item} key={item.id} />
            ))}
          </Row>
        </Container>
      </section>
      {/* =============== Car Details Section =============== */}
      {/* <section>
      
        <Container>
          
          <Row>
            <Col lg="12" className="text-center mb-5">
              <h6 className="section__subtitle">Car Details</h6>
            </Col>

            {cars.map((item) => (
              <CarDetails item={item} key={item.id} />
            ))}
          </Row>
        </Container>
      </section> */}
      
    </Helmet>
  );
};

export default Home;
