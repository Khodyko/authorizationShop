package com.example.shop.converter;

import com.example.shop.entity.dto.UserDto;
import com.example.shop.entity.request.UserRequest;
import com.example.shop.entity.response.list.UserResponseList;
import com.example.shop.entity.response.mono.UserResponseMono;
import com.example.shop.entity.simple.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(config = MapStructConfiguration.class)
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

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
