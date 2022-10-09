package com.tecfit.rest;

import com.tecfit.model.User;
import com.tecfit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserControler {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public User add(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/search/{Email}")
    public User findByEmail(@PathVariable("Email")String Email) throws Exception {
        return userService.findByEmail(Email);
    }

}
