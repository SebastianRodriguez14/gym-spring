package com.tecfit.service;

import com.tecfit.model.User;

public interface UserService {
    User save(User user);
    User findByEmail(String Email) throws Exception;
}
