package com.app.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.app.dto.ApiResponse;
import com.app.entity.Cars;
import com.app.repository.CarsRepository;

@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {

    @Autowired
    private CarsRepository carRepo;

    @Override
    public ApiResponse uploadImage(Long carId, MultipartFile image) throws IOException {
        Cars car = carRepo.findById(carId).orElseThrow();
        car.setImage(image.getBytes());
        carRepo.save(car);
        return new ApiResponse("Image Added Successfully");
    }

    @Override
    public byte[] downloadImage(Long carId) throws IOException {
        Cars car = carRepo.findById(carId).orElseThrow();
        return car.getImage();
    }
}
