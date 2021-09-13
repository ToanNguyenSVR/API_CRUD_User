package com.example.resfulapi.model.mapper;

import com.example.resfulapi.entity.User;
import com.example.resfulapi.model.DTO.UserDTO;

public class UserMapper {
    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPhone(user.getPhone());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        return userDTO ;
    }
}
