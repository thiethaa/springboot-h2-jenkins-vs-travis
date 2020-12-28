package com.thiethaa.springbooth2.controller;

import com.thiethaa.springbooth2.entity.User;
import com.thiethaa.springbooth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userlist")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return userService.getUserbyId(id);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("edit/{id}")
    public User editUser(@RequestBody User user, @PathVariable("id") String id) {
        return userService.editUser(user, id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }
}
