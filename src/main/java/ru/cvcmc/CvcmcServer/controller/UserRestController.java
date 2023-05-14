package ru.cvcmc.CvcmcServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.cvcmc.CvcmcServer.entity.User;
import ru.cvcmc.CvcmcServer.service.UserService;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> users(Model model) {
        return userService.allUsers();
    }

    @PostMapping("/users")
    public User usersAdd(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

}
