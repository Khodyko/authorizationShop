package com.example.shop.mapper;

import com.example.shop.entity.user.User;
import com.example.shop.entity.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UserMapper.class })
public interface UserMapper {
    public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public UserDto userDto(User user);
    public User user(UserDto userDto);
}
