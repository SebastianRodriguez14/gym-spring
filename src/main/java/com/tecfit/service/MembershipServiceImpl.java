package com.tecfit.service;

import com.tecfit.model.Membership;
import com.tecfit.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MembershipServiceImpl implements MembershipService{

    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public Collection<Membership> findAll() {
        return membershipRepository.findAll();
    }

    @Override
    public Membership findById(Integer id) {
        return membershipRepository.findById(id).get();
    }
}
