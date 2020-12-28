package com.thiethaa.springbooth2.service;

import com.thiethaa.springbooth2.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserbyId(String id);

    User addUser(User user);

    User editUser(User user, String id);

    void deleteUser(String id);
}
