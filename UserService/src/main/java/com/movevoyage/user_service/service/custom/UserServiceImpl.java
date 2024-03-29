package com.movevoyage.user_service.service.custom;


import com.movevoyage.user_service.dto.UserDto;
import com.movevoyage.user_service.entity.User;
import com.movevoyage.user_service.payload.responses.MessageResponse;
import com.movevoyage.user_service.repository.UserRepository;
import com.movevoyage.user_service.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Value("${mail-service-url}")
    private String mailServer;

//    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, String mailUrl) {
//        this.userRepository = userRepository;
//        this.modelMapper = modelMapper;
//        MAIL_SERVER_URL = mailUrl;
//    }

    @Override
    public Boolean existsUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

    @Override
    public Boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public Boolean deleteByUsername(String username) {
        return userRepository.deleteUserByUsername(username);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsersList() {
        return null;
    }

    /*@Override
    public List<UserDto> getAllUsersList() {
        List<User> usersList = userRepository.getAll();
        if (usersList.isEmpty()) return null;
        return usersList.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }*/

    @Override
    public String getOngoingUserID() {
//        System.out.println("get new user id");
        List<User> lastInsertedUser = userRepository.findLastInsertedUser();
//        System.out.println(lastInsertedUser);
        if (lastInsertedUser.isEmpty()) return "U00001";
//        System.out.println("last user id: " + lastInsertedUser.get(0).getUser_id());
        String lastId = lastInsertedUser.get(0).getUser_id();
        String[] split = lastId.split("[U]");
//        System.out.println("split: " + split[1]);
        int lastDigits = Integer.parseInt(split[1]);
        lastDigits++;
        return (String.format("U%05d", lastDigits));
    }

    @Override
    public Boolean save(UserDto userDto) throws RuntimeException {
        User user = new User();

        user.setUser_id(userDto.getUser_id());
        user.setUsername(userDto.getUsername());
        user.setNic_no(userDto.getNic_no());
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setContact_number(userDto.getContact_number());
        user.setRemark(userDto.getRemark());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setNic_front(userDto.getNic_front());
        user.setNic_back(userDto.getNic_back());

        userRepository.save(user);

        WebClient client = WebClient.create( mailServer + "/email/send/welcome");
        client.post().header("mail", user.getEmail()).retrieve().bodyToMono(MessageResponse.class).block();

        return true;
    }

}
