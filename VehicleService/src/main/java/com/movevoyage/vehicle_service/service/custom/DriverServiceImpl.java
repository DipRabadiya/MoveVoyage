package com.movevoyage.vehicle_service.service.custom;

import com.movevoyage.vehicle_service.dto.DriverDto;
import com.movevoyage.vehicle_service.entity.Driver;
import com.movevoyage.vehicle_service.repository.DriverRepository;
import com.movevoyage.vehicle_service.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final ModelMapper modelMapper;
    private final DriverRepository driverRepository;

    @Override
    public Boolean save(DriverDto driver) {
//        System.out.println("DriverServiceImpl -> save");
        Driver mapped = modelMapper.map(driver, Driver.class);
//        System.out.println(driver);
//        System.out.println("DriverServiceImpl -> mapped");
        driverRepository.save(mapped);
//        System.out.println(driver);
//        System.out.println("Driver saved");
        return true;
    }

    @Override
    public Boolean existsDriverByDriverId(String driver_id) {
//        System.out.println("DriverServiceImpl -> existsDriverByDriverId");
        boolean b = driverRepository.existsById(driver_id);
//        boolean b = driverRepository.findById(driver_id);
//        System.out.println("DriverServiceImpl -> existsDriverByDriverId -> " + b);
        return b;
    }

//    @Override
//    public DriverDto findDriverById(String driver_id) {
//        if (driverRepository.existsById(driver_id))
//            return modelMapper.map(driverRepository.getById(driver_id), DriverDto.class);
//        throw new RuntimeException("Driver not found!");
//    }

    @Override
    public DriverDto findDriverById(String id) {
        if(driverRepository.existsById(id))
            return modelMapper.map(driverRepository.existsById(id), DriverDto.class);
        throw new RuntimeException("Driver not found!");
    }

    @Override
    public String getOngoingId() {
        String lastDriverId = driverRepository.findLastId();
        System.out.println("last ongoing Driver -> " + lastDriverId);
//        System.out.println(lastInsertedUser);
        if (lastDriverId==null) return "D00001";
        String[] split = lastDriverId.split("[D]");
        int lastDigits = Integer.parseInt(split[1]);
        lastDigits++;
        return (String.format("D%05d", lastDigits));
    }

    @Override
    public Optional<Driver> getDriverById(String id) {
        return driverRepository.findById(id);
    }
}
