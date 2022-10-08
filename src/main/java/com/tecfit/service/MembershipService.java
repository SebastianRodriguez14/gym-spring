package com.tecfit.service;

import com.tecfit.model.Membership;

import java.util.Collection;

public interface MembershipService {
    Collection<Membership> findAll();
    Membership findById(Integer id);
}
