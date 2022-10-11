package com.tecfit.service;

import com.tecfit.model.User;
import com.tecfit.repository.UserRepository;
import com.tecfit.security.Encrypt;
import com.tecfit.security.IEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private final IEncrypt encryptService = new Encrypt();

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        user.setPassword(encryptService.encryptPassword(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String Email) throws Exception{
        return userRepository.findByEmail(Email);
    }

}
