package com.tecfit.service;

import com.tecfit.model.Membership;

import java.util.Collection;
import java.util.Optional;

public interface MembershipService {
    Collection<Membership> findAll();
    Membership findById(Integer id);

    Optional<Membership> checkMembershipByUser(Integer id_user);

}
