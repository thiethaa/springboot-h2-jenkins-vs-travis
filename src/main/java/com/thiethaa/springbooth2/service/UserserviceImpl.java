package com.thiethaa.springbooth2.service;

import com.thiethaa.springbooth2.entity.User;
import com.thiethaa.springbooth2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserserviceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserbyId(String id) {
        Optional<User> exisUser = userRepo.findById(id);
        User user = null;
        if(exisUser.isPresent()){
            user = exisUser.get();
        }
        return user;
    }

    @Override
    public User addUser(User newUser) {
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        userRepo.save(user);
        return user;
    }

    @Override
    public User editUser(User newUser, String id) {
        Optional<User> exisUser = userRepo.findById(id);
        User user = null;
        if(exisUser.isPresent()){
            user = exisUser.get();
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            userRepo.save(user);
        }
        return user;
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
}
