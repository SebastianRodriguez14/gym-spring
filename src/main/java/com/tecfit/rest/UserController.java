package com.tecfit.rest;

import com.tecfit.model.User;
import com.tecfit.security.Encrypt;
import com.tecfit.security.IEncrypt;
import com.tecfit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    private final IEncrypt encryptService = new Encrypt();


    @GetMapping("/all")
    public Collection<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/save")
    public User add(@RequestBody User user){
        user.setPassword(encryptService.encryptPassword(user.getPassword()));
        return userService.save(user);
    }

    @GetMapping("/search/{Email}")
    public User findByEmail(@PathVariable("Email")String Email) throws Exception {
        return userService.findByEmail(Email);
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<?> updateUser(@PathVariable("email")String email, @RequestBody User user) throws Exception {
        User user1 = userService.findByEmail(email);
        if(user1 != null){
            user.setId_user(user1.getId_user());
            user.setEmail(user1.getEmail());
            user.setPassword(user1.getPassword());
            return new ResponseEntity<>(userService.commonSave(user), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
        }
    }

}
