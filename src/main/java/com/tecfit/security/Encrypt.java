package com.tecfit.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encrypt implements IEncrypt {

    BCryptPasswordEncoder passwordEncoded = new BCryptPasswordEncoder();

    @Override
    public String encryptPassword(String password) {
        return passwordEncoded.encode(password);
    }
}
