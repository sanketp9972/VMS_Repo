package com.app.repository;

import com.app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByBookingCarId(Long carId);
    // Additional methods if needed
    
    Optional<Users> findByEmailAndPassword(String em,String pass);
}
