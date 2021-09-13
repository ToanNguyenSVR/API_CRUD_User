package com.example.resfulapi.service.impl;

import com.example.resfulapi.entity.User;
import com.example.resfulapi.model.DTO.UserDTO;
import com.example.resfulapi.model.mapper.UserMapper;
import com.example.resfulapi.reponsitory.UserReponsitory;
import com.example.resfulapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserReponsitory userReponsitory ;

    @Override
    public List<UserDTO> findAll() {
       List<User> users = userReponsitory.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User u: users ) {
            userDTOS.add(UserMapper.toUserDTO(u));

        }
        return userDTOS ;
    }

    @Override
    public UserDTO findById(Long id) {
        return UserMapper.toUserDTO(userReponsitory.findById(id).get());
    }

    @Override
    public List<UserDTO> findByName(String name) {
        List<User> users = userReponsitory.findByName(name);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User u: users ) {
            userDTOS.add(UserMapper.toUserDTO(u));

        }
        return userDTOS;
    }

    @Override
    public UserDTO save(User user) {
        return UserMapper.toUserDTO(userReponsitory.save(user));
    }

    @Override
    public UserDTO delete(Long id) {
        User u = userReponsitory.findById(id).get();
        userReponsitory.deleteById(id);
        return UserMapper.toUserDTO(u) ;

    }
}
