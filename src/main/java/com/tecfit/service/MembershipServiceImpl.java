package com.tecfit.service;

import com.tecfit.model.Membership;
import com.tecfit.model.User;
import com.tecfit.model.custom.ExpiryDate;
import com.tecfit.repository.MembershipRepository;
import com.tecfit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
public class MembershipServiceImpl implements MembershipService{



    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<Membership> findAll() {
        return membershipRepository.findAll();
    }

    @Override
    public Membership findById(Integer id) {
        return membershipRepository.findById(id).get();
    }

    @Override
    public Optional<Membership> checkMembershipByUser(Integer id_user) {

        Optional<Membership> membership = membershipRepository.checkMembershipByUser(id_user);

        if (!membership.isPresent()){
            userRepository.updateMembership(false, id_user);
        }

        return membership;

    }

    @Override
    public Membership save(Membership membership) {
        User user = membership.getUser();
        user.setMembership(true);
        membership.setUser(userRepository.save(user));
        return membershipRepository.save(membership);
    }

    @Override
    public Collection<Membership> membershipsToFinish() {
        Date now = new Date();
        System.out.println(new Date( now.getTime() + (5000 * 60 * 60 * 24)));
        return membershipRepository.membershipsToFinish(new Date( now.getTime() + (5000 * 60 * 60 * 24)));
    }

    @Override
    public Membership saveMembership(Membership membership) {
        User user = userRepository.getById(membership.getUser().getId_user());
        user.setMembership(true);
        membership.setUser(userRepository.save(user));
        return membershipRepository.save(membership);

    }

    @Override
    @Transactional
    public void updateExpiryDate(ExpiryDate expiry, Integer id) {
        membershipRepository.updateExpiryDate(expiry.getDate(),expiry.getPayment(),id);
    }
}
