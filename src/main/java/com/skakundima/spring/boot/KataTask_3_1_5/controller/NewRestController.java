package com.skakundima.spring.boot.KataTask_3_1_5.controller;

import com.skakundima.spring.boot.KataTask_3_1_5.model.Role;
import com.skakundima.spring.boot.KataTask_3_1_5.model.User;
import com.skakundima.spring.boot.KataTask_3_1_5.service.RoleService;
import com.skakundima.spring.boot.KataTask_3_1_5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class NewRestController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public NewRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users") // Show all
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}") // show by id
    public ResponseEntity<User> getUser(@PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users") // add user
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PatchMapping("/users/{id}") // edit user
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable("id") Long id) {
        userService.editUser(id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}") // drop user
    public ResponseEntity<User> delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/roles") // get roles
    ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/roles/{id}") // get one role
    ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(roleService.getRoleById(id), HttpStatus.OK);
    }
}
