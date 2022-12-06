package com.tecfit.service;

import com.tecfit.model.Membership;
import com.tecfit.model.custom.ExpiryDate;

import java.util.Collection;
import java.util.Optional;

public interface MembershipService {
    Collection<Membership> findAll();
    Membership findById(Integer id);

    Optional<Membership> checkMembershipByUser(Integer id_user);

    Membership save(Membership membership);

    Collection<Membership> membershipsToFinish();

    Membership saveMembership(Membership membership);

    void updateExpiryDate(ExpiryDate expiry, Integer id);

}
