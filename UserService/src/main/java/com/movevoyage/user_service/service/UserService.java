package com.movevoyage.user_service.service;



import com.movevoyage.user_service.dto.UserDto;

import java.util.List;

public interface UserService {
    Boolean existsUserByUsername(String username);
    Boolean existsUserByEmail(String email);
    String getOngoingUserID();
    Boolean save(UserDto userDto);
    Boolean deleteByUsername (String username);
    UserDto getUserByUsername (String username);
    List<UserDto> getAllUsersList();

}
