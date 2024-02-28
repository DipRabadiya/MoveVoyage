package com.movevoyage.repository;

import com.movevoyage.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    boolean existsById(String id);
    @Query(value = "SELECT id FROM booking ORDER BY id DESC LIMIT 1", nativeQuery = true)
    List<Booking> getLastBookingId();
    List<Booking> findAllByUserAndStatus(String user, String status);

    Booking getBookingById(String id);

    List<Booking> findAllByUser(String user);
}