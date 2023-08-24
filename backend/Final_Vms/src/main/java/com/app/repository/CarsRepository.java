package com.app.repository;

import com.app.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
//	FOR SEARCH CAR
	@Query("SELECT c FROM Cars c LEFT JOIN FETCH c.carSpecification WHERE c.brandName = :brandName AND c.modelName = :modelName")
    Optional<Cars> findCarByBrandAndModelWithSpec(@Param("brandName") String brandName, @Param("modelName") String modelName);
	
	//GET ALL CARS WITH SPECIFICATIONS 
	 @Query("SELECT c FROM Cars c LEFT JOIN FETCH c.carSpecification WHERE c.id = :carId")
	 Cars findCarWithSpecificationById(@Param("carId") Long carId);

	 List<Cars> findByBrandNameOrModelName(String brandName, String modelName);
    
    List<Cars> findAllByCarSpecificationIsNotNull();

    List<Cars> findAllByCarSpecificationIsNull();
    
    
}
