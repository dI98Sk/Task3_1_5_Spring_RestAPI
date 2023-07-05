package com.skakundima.spring.boot.KataTask_3_1_5.dao;



import com.skakundima.spring.boot.KataTask_3_1_5.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();
    void save(Role role);
    Role findById(Long id);
    void deleteById(Long id);
    Role getRoleByName(String name);
}
