package com.movevoyage.repository;

import com.movevoyage.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<Guide, String> {
    boolean existsById(String id);
    boolean deleteGuideById(String id);

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    List<Guide> getLastGuideId();
    Guide getGuideById(String id);

}
