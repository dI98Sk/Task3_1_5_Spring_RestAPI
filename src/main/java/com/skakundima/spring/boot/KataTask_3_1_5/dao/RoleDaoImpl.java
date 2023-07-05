package com.skakundima.spring.boot.KataTask_3_1_5.dao;

import com.skakundima.spring.boot.KataTask_3_1_5.model.Role;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> findAll() {
        return new ArrayList<Role>(entityManager.createQuery("FROM Role", Role.class).getResultList());
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery("SELECT r FROM Role r WHERE r.name = :name")
                .setParameter("name", name).getResultList().get(0);
    }
}
