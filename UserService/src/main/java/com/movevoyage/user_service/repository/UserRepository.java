package com.movevoyage.user_service.repository;


import com.movevoyage.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByUsername(String name);

    Boolean existsUserByUsername(String username);


    Boolean existsUserByEmail(String email);

    @Query(value = "SELECT * FROM user ORDER BY created_time DESC LIMIT 1", nativeQuery = true)
    List<User> findLastInsertedUser();

    Boolean deleteUserByUsername(String username);
//    List<User> getAll();

    User getUserByUsername(String username);
}
