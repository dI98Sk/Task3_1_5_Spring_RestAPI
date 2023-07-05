package com.skakundima.spring.boot.KataTask_3_1_5.service;

import com.skakundima.spring.boot.KataTask_3_1_5.dao.RoleDao;
import com.skakundima.spring.boot.KataTask_3_1_5.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.findById(id);
    }
}
