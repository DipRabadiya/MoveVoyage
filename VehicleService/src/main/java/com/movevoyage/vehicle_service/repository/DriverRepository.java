package com.movevoyage.vehicle_service.repository;

import com.movevoyage.vehicle_service.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface DriverRepository extends JpaRepository<Driver, String> {

    boolean existsById(String driver_id);

//    @Query("SELECT d FROM driver d WHERE d.id = :id")
    Driver getDriverById(String driver_id);


    @Query("SELECT MAX (d.id) FROM Driver d")
    String findLastId();


}
