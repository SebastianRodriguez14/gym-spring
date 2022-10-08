package com.tecfit.service;

import com.tecfit.model.User;
import com.tecfit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String Email) throws Exception{
        return userRepository.findByEmail(Email);
    }

}
