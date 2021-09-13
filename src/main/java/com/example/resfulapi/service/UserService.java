package com.example.resfulapi.service;

import com.example.resfulapi.entity.User;
import com.example.resfulapi.model.DTO.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> findAll();
    public UserDTO findById(Long id);
    public  List<UserDTO> findByName(String name );
    public UserDTO save(User user);
    public UserDTO delete(Long id);

}
