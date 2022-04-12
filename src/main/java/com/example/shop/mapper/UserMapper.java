package com.example.shop.mapper;

import com.example.shop.entity.dtoEntity.UserDto;
import com.example.shop.entity.requestEntity.UserRequest;
import com.example.shop.entity.responseEntity.UserResponse;
import com.example.shop.entity.simpleEntity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class}) //TODO Можешь вынести в конфиг
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    User userRequestToUser(UserRequest userRequest);

    default UserResponse userDtoToUserResponse(List<UserDto> userDtoList) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsers(userDtoList);

        return userResponse;
    }

    default UserResponse userDtoToUserResponse(UserDto userDto) {
        UserResponse userResponse = new UserResponse();
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(userDto);
        userResponse.setUsers(userDtoList);

        return userResponse;
    }

}
