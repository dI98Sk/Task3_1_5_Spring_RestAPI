package com.skakundima.spring.boot.KataTask_3_1_5.initialization;

import com.skakundima.spring.boot.KataTask_3_1_5.model.Role;
import com.skakundima.spring.boot.KataTask_3_1_5.model.User;
import com.skakundima.spring.boot.KataTask_3_1_5.service.RoleService;
import com.skakundima.spring.boot.KataTask_3_1_5.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitDB {

    private final RoleService roleService;
    private final UserService userService;

    public InitDB(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }
//Создаём юзеров
    @PostConstruct
    @Transactional
    public void fillDb() {

        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");


        roleService.saveRole(role1);
        roleService.saveRole(role2);

        Set<Role> set1 = new HashSet<>();
        set1.add(role1);
        Set<Role> set2 = new HashSet<>();
        set2.add(role2);

        User user1 = new User("Dmitrii", "Skakun", 25,
                "skakun@gmail.com", "1", set1 );
        User user2 = new User("Georgio", "Sidorov", 25,
                "sidorov@gmail.com", "2", set2 );

        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}
