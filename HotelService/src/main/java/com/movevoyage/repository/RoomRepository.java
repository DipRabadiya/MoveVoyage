package com.movevoyage.repository;

import com.movevoyage.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RoomRepository extends JpaRepository<Options, String> {
}
