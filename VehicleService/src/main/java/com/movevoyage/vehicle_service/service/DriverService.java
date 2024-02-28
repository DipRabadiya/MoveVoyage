package com.movevoyage.vehicle_service.service;


import com.movevoyage.vehicle_service.dto.DriverDto;

public interface DriverService {
    Boolean save(DriverDto driver);

    Boolean existsDriverByDriverId(String driver_id);

    DriverDto findDriverById(String driver_id);

    String getOngoingId();

}
