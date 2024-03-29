package com.movevoyage.repository;

import com.movevoyage.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
public interface HotelRepository extends JpaRepository<Hotel, String> {
    @Query("SELECT MAX (h.id) FROM Hotel h")
    String findLastHotelId();

    Hotel findHotelById(String id);

    boolean existsHotelById(String id);

    @Transactional
    void deleteHotelById(String id);
}
