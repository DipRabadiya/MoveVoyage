package com.movevoyage.service;



import com.movevoyage.dto.HotelDto;

import java.util.List;

public interface HotelService {
    String getOngoingHotelId();
    List<HotelDto> getAllHotels() throws RuntimeException ;

    HotelDto getHotelById(String id);

    boolean save(HotelDto hotelDto);

    boolean existsHotelById(String id);

    boolean deleteHotelById(String id);
}
