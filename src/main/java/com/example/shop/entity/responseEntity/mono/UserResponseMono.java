package com.example.shop.entity.responseEntity.mono;

import com.example.shop.entity.dtoEntity.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseMono {
    UserDto userDto;
}
