package com.example.resfulapi.api;

import com.example.resfulapi.entity.User;
import com.example.resfulapi.model.DTO.UserDTO;
import com.example.resfulapi.reponsitory.UserReponsitory;
import com.example.resfulapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    UserService userService ;
    @Autowired
    UserReponsitory userReponsitory ;
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser(){
        List<UserDTO> users = userService.findAll();
//        for(int i = 0 ; i< 100 ; i ++){
//            User user = new User();
//            user.setName("Name" + i );
//            user.setPassword("Password" + i );
//            user.setAddress("Address" + i );
//            user.setEmail("Email" + i );
//            user.setPhone("phone" + i );
//            userReponsitory.save(user);
//        }
        return ResponseEntity.ok(users);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long userID){
        UserDTO user = userService.findById(userID);
        return ResponseEntity.ok(user);
    }
    // tạo user
    @PostMapping("/users")
    public  ResponseEntity<?> create(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }
    // update user
    @PutMapping("/users/{id}")
    public  ResponseEntity<?> update(@RequestBody User user , @PathVariable (name = "id") Long id){
       User u = userReponsitory.findById(id).get();
       if(u != null ){
           user.setId(id);
           userService.save(user);
       }
        return ResponseEntity.ok(u);
    }
    // delete user
    @DeleteMapping("/users/{id}")
    public  ResponseEntity<?> deletw(@PathVariable (name = "id") Long id){
       return ResponseEntity.ok(userService.delete(id));
    }





}
