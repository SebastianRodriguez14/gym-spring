package com.tecfit.rest;

import com.tecfit.model.Membership;
import com.tecfit.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("membership")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @GetMapping("/all")
    public Collection<Membership> findAll(){
        return membershipService.findAll();
    }

    @GetMapping("/{id}")
    public Membership findById(@PathVariable("id") int id){
        return membershipService.findById(id);
    }

    @GetMapping("/check/{id_user}")
    public Optional<Membership> checkMembershipByUser(@PathVariable("id_user") int id_user){

        return membershipService.checkMembershipByUser(id_user);

    }


}
