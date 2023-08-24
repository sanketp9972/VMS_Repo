import React from "react";
import Slider from "react-slick";

import "../../styles/testimonial.css";

import ava01 from "../../assets/all-images/ava-1.jpg";
import ava02 from "../../assets/all-images/ava-2.jpg";
import ava03 from "../../assets/all-images/ava-3.jpg";
import ava04 from "../../assets/all-images/ava-4.jpg";

const Testimonial = () => {
  // const settings = {
  //   dots: true,
  //   infinite: true,
  //   autoplay: true,
  //   speed: 1000,
  //   swipeToSlide: true,
  //   autoplaySpeed: 2000,
  //   slidesToShow: 3,
  //   slidesToScroll: 1,
  //   responsive: [
  //     {
  //       breakpoint: 992,
  //       settings: {
  //         slidesToShow: 2,
  //         slidesToScroll: 1,
  //         infinite: true,
  //         dots: true,
  //       },
  //     },
  //     {
  //       breakpoint: 576,
  //       settings: {
  //         slidesToShow: 1,
  //         slidesToScroll: 1,
  //       },
  //     },
  //   ],
  // };

  // return (
  //   <Slider {...settings}>
  //     <div className="testimonial py-4 px-3">
  //       <p className="section__description">
  //       "I couldn't be happier with the customer service I received at this car showroom. 
  //       From the moment I walked in, I felt valued and appreciated. 
  //       The team went above and beyond to ensure I got the best deal and even helped me with financing options. 
  //       I'm beyond thrilled with my new car and will definitely recommend this showroom to my friends!"
  //       </p>

  //       <div className="mt-3 d-flex align-items-center gap-4">
  //         <img src={ava01} alt="" className="w-25 h-25 rounded-2" />

  //         <div>
  //           <h6 className="mb-0 mt-3">Jhon Doe</h6>
  //           <p className="section__description">Customer</p>
  //         </div>
  //       </div>
  //     </div>

  //     <div className="testimonial py-4 px-3">
  //       <p className="section__description">
  //       "I had a fantastic experience at the car showroom! 
  //       The staff was very helpful in assisting me with finding the perfect car. 
  //       The test drive was smooth, and I'm extremely satisfied with my purchase. 
  //       Thank you for making the process easy and enjoyable!"
  //       </p>

  //       <div className="mt-3 d-flex align-items-center gap-4">
  //         <img src={ava02} alt="" className="w-25 h-25 rounded-2" />

  //         <div>
  //           <h6 className="mb-0 mt-3">Jane Smith</h6>
  //           <p className="section__description">Customer</p>
  //         </div>
  //       </div>
  //     </div>

  //     <div className="testimonial py-4 px-3">
  //       <p className="section__description">
  //       "I highly recommend this car showroom! T
  //       he selection of cars is impressive, and the team was knowledgeable about all the models. 
  //       They patiently answered all my questions and helped me make an informed decision. 
  //       The buying process was straightforward, and I'm thrilled with my new car!"
  //       </p>

  //       <div className="mt-3 d-flex align-items-center gap-4">
  //         <img src={ava03} alt="" className="w-25 h-25 rounded-2" />

  //         <div>
  //           <h6 className="mb-0 mt-3"> Michael Johnson</h6>
  //           <p className="section__description">Customer</p>
  //         </div>
  //       </div>
  //     </div>

  //     <div className="testimonial py-4 px-3">
  //       <p className="section__description">
  //       "The service at this car showroom is top-notch! 
  //       I came in for a test drive and was impressed by the professionalism and friendliness of the staff. 
  //       They didn't pressure me into buying and allowed me to take my time. 
  //       I found the perfect car for my needs, and the entire experience was enjoyable."
  //       </p>

  //       <div className="mt-3 d-flex align-items-center gap-4">
  //         <img src={ava04} alt="" className="w-25 h-25 rounded-2" />

  //         <div>
  //           <h6 className="mb-0 mt-3">Emily Williams</h6>
  //           <p className="section__description">Customer</p>
  //         </div>
  //       </div>
  //     </div>
  //   </Slider>
  // );
};

export default Testimonial;
