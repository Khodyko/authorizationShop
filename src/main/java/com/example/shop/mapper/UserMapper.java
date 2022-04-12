package com.example.shop.mapper;

import com.example.shop.entity.dtoEntity.UserDto;
import com.example.shop.entity.requestEntity.UserRequest;
import com.example.shop.entity.responseEntity.list.UserResponseList;
import com.example.shop.entity.responseEntity.mono.UserResponseMono;
import com.example.shop.entity.simpleEntity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class}) //TODO Можешь вынести в конфиг
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    User userRequestToUser(UserRequest userRequest);
    UserDto userRequestToUserDto(UserRequest userRequest);

    default UserResponseList userDtoToUserResponseList(List<UserDto> userDtoList) {
        UserResponseList userResponse = new UserResponseList();
        userResponse.setUsers(userDtoList);

        return userResponse;
    }

    default UserResponseMono userDtoToUserResponseMono(UserDto userDto) {
      return new UserResponseMono(userDto);
    }
}
