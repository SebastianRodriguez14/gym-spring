package com.tecfit.rest;

import com.tecfit.model.Membership;
import com.tecfit.model.User;
import com.tecfit.model.custom.AnyDate;
import com.tecfit.service.MembershipService;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/toFinish")
    public Collection<Membership> listToFinish(){
        return membershipService.membershipsToFinish();
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
        return membershipService.saveMembership(membership);
    }

    @PutMapping("/update/{id_membership}")
    public ResponseEntity<?> updateExpiryDate(@RequestBody AnyDate date, @PathVariable("id_membership") int id){
        membershipService.updateExpiryDate(date, id);
        return new ResponseEntity<>("Membership Updated",HttpStatus.OK);
    }

}
