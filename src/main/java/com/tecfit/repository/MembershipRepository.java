package com.tecfit.repository;

import com.tecfit.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Integer> {
}
