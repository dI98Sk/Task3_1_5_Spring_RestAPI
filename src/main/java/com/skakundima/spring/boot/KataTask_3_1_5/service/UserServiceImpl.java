package com.skakundima.spring.boot.KataTask_3_1_5.service;

import com.skakundima.spring.boot.KataTask_3_1_5.dao.UserDao;
import com.skakundima.spring.boot.KataTask_3_1_5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserDao userDao) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userDao.findByEmail(user.getEmail()) != null) {
            return;
        }
        userDao.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userDao.findByEmail(username);
    }

    @Override
    @Transactional
    public void editUser(Long id, User user) {
        user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.update(user);
    }
}