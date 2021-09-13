package com.example.resfulapi.reponsitory;

import com.example.resfulapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserReponsitory extends JpaRepository<User , Long > {
    public List<User> findByName(String name);

}
