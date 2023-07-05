package com.skakundima.spring.boot.KataTask_3_1_5.service;



import com.skakundima.spring.boot.KataTask_3_1_5.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    void saveRole(Role role);
    Role getRoleById(Long id);
}
