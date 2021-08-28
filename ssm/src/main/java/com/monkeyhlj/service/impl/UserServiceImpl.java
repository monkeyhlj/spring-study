package com.monkeyhlj.service.impl;

import com.monkeyhlj.entity.User;
import com.monkeyhlj.repository.UserRepository;
import com.monkeyhlj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
