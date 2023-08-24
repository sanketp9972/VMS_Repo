package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.TestDrive;

@Repository
public interface TestDriveRepository extends JpaRepository<TestDrive, Long> {
}

