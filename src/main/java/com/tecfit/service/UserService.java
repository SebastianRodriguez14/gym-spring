package com.tecfit.service;

import com.tecfit.model.User;

import java.util.Collection;

public interface UserService {

    Collection<User> findAll();
    User save(User user);
    User findByEmail(String Email) throws Exception;
}
