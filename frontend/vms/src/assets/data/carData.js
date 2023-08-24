// import all images from assets/images directory
import img01 from "../all-images/cars-img/nissan-offer.png";
import img02 from "../all-images/cars-img/offer-toyota.png";
import img03 from "../all-images/cars-img/bmw-offer.png";
import img04 from "../all-images/cars-img/nissan-offer.png";
import img05 from "../all-images/cars-img/offer-toyota.png";
import img06 from "../all-images/cars-img/mercedes-offer.png";
import img07 from "../all-images/cars-img/toyota-offer-2.png";
import img08 from "../all-images/cars-img/mercedes-offer.png";

const carData = [
  {
    id: 1,
    brand: "Tesla",
    rating: 112,
    carName: "Tesla Model X",
    imgUrl: img01,
    model: "Model 3",
    price: 5000000 ,
    speed: "20kmpl",
    gps: "GPS Navigation",
    seatType: "Heated seats",
    automatic: "Automatic",
    description:
      " The Tesla Model X is a battery electric mid-size luxury crossover SUV produced by Tesla, Inc. since 2015. Developed from the full-sized sedan platform of the Tesla Model S, the vehicle notably uses falcon wing doors for passenger access.",
  },

  {
    id: 2,
    brand: "Toyota",
    rating: 102,
    carName: "Toyota Camry",
    imgUrl: img02,
    model: "Model-2022",
    price: 3000000,
    speed: "20kmpl",
    gps: "GPS Navigation",
    seatType: "Heated seats",
    automatic: "Automatic",
    description:
      " Experience the pinnacle of luxury as soon as you step into the new Camry, with floating type audio. The infotainment system now features a large floating screen, surrounded by meticulously ornamented panels. All to epitomise powerful luxury.",
  },

  {
    id: 3,
    brand: "BMW",
    rating: 132,
    carName: "BMW X3",
    imgUrl: img03,
    model: "Model-2022",
    price: 6000000,
    speed: "20kmpl",
    gps: "GPS Navigation",
    seatType: "Heated seats",
    automatic: "Automatic",
    description:
      " The exquisite feel of luxury finally meets the exhilarating zeal of performance. With interiors so grand, features so advanced and performance so powerful, the BMW X3 is ready to serve an experience that’s nothing like you’ve felt before.",
  },

  {
    id: 4,
    brand: "Nissan",
    rating: 102,
    carName: "Nissan Mercielago",
    imgUrl: img04,
    model: "Model-2022",
    price: 3600000,
    speed: "20kmpl",
    gps: "GPS Navigation",
    seatType: "Heated seats",
    automatic: "Automatic",
    description:
      " Over the years, Nissan has become a renowned brand because of its high reliability, outstanding safety ratings, and innovative designs.",
  },

  {
    id: 5,
    brand: "Ferrari",
    rating: 94,
    carName: "Ferrari SF90",
    imgUrl: img05,
    model: "Model-2022",
    price: 9000000,
    speed: "20kmpl",
    gps: "GPS Navigation",
    seatType: "Heated seats",
    automatic: "Automatic",
    description:
      " Ferrari S.p.A. (/fəˈrɑːri/; Italian: [ferˈraːri]) is an Italian luxury sports car manufacturer based in Maranello, Italy. Founded in 1939 by Enzo Ferrari (1898–1988), the company adopted its current name in 1945 and began producing its line of cars in 1947.",
  },

  {
    id: 6,
    brand: "Mercedes",
    rating: 119,
    carName: "Mercedes Benz S Class ",
    imgUrl: img06,
    model: "Model-2022",
    price: 8500000,
    speed: "20kmpl",
    gps: "GPS Navigation",
    seatType: "Heated seats",
    automatic: "Automatic",
    description:
      " The Mercedes-Benz S-Class, formerly known as Sonderklasse German for special class, abbreviated as S-Klasse, is a series of full-sized luxury sedans, limousines and armored sedans produced by the German automaker Mercedes-Benz.",
  },

  {
    id: 7,
    brand: "Audi",
    rating: 82,
    carName: "Audi A4",
    imgUrl: img07,
    model: "Audi A4",
    price: 6500000,
    speed: "20kmpl",
    gps: "GPS Navigation",
    seatType: "Heated seats",
    automatic: "Automatic",
    description:
      " The Audi A4 is the perfect case of 'Do not judge a book by its cover'. We have driven it in the updated guise. Read on to find out more",
  },

  {
    id: 8,
    brand: "Phantom",
    rating: 52,
    carName: "Rolls Royce Phantom",
    imgUrl: img08,
    model: "Model 3",
    price: 10000000,
    speed: "20kmpl",
    gps: "GPS Navigation",
    seatType: "Heated seats",
    automatic: "Automatic",
    description:
      " The Rolls-Royce Phantom is a full-sized luxury saloon manufactured by Rolls-Royce Motor Cars. It is the eighth and current generation of the Rolls-Royce Phantom, debuting in 2017, and the second launched by Rolls-Royce under BMW ownership. It is offered in two wheelbase lengths. This is the current flagship model made by Rolls-Royce Motor Cars.",
  },
];

export default carData;
