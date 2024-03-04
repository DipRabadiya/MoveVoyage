package com.movevoyage.vehicle_service.service;


import com.movevoyage.vehicle_service.dto.DriverDto;
import com.movevoyage.vehicle_service.entity.Driver;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverService {
    Boolean save(DriverDto driver);

    Boolean existsDriverByDriverId(String driver_id);

    @Query()
    DriverDto findDriverById(String driver_id);

    String getOngoingId();

    Optional<Driver> getDriverById(String id);
}
