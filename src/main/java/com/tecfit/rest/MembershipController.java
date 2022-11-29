package com.tecfit.rest;

import com.tecfit.model.Membership;
import com.tecfit.model.User;
import com.tecfit.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Date;
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

    @PostMapping("/saveWithUser")
    public Membership registerWithUser(@RequestBody Membership membership){
        return membershipService.save(membership);
    }

    @PostMapping("/save/{id_user}")
    public Membership registerMembership(@PathVariable("id_user") int id ,@RequestBody Membership membership){
        User user = new User();
        user.setId_user(id);
        membership.setUser(user);
        membership.setStart_date(new Date(membership.getStart_date().getTime() + (1000 * 60 * 60 * 24)));
        membership.setExpiration_date(new Date(membership.getExpiration_date().getTime() + (1000 * 60 * 60 * 24)));

        return membershipService.saveMembership(membership);
    }

}
