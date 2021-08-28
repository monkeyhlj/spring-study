package com.monkeyhlj.repository;

import com.monkeyhlj.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
}
