package com.skakundima.spring.boot.KataTask_3_1_5.service;

import com.skakundima.spring.boot.KataTask_3_1_5.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
    UserDetails loadUserByUsername(String email);
    void editUser(Long id, User user);
}
