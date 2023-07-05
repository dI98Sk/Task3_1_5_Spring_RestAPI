package com.skakundima.spring.boot.KataTask_3_1_5.dao;



import com.skakundima.spring.boot.KataTask_3_1_5.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void save(User user);

    void update(User user);

    void deleteById(Long id);

    User findById(Long id);

    User findByEmail(String email);
}
