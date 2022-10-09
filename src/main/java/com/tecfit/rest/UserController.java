package com.tecfit.rest;

import com.tecfit.model.User;
import com.tecfit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public Collection<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/save")
    public User add(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/search/{Email}")
    public User findByEmail(@PathVariable("Email")String Email) throws Exception {
        return userService.findByEmail(Email);
    }

}
