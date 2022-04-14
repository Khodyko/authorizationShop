package com.example.shop.entity.response.mono;

import com.example.shop.entity.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseMono {
    UserDto userDto;
}
