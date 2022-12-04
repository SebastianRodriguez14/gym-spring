package com.tecfit.repository;

import com.tecfit.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public interface MembershipRepository extends JpaRepository<Membership, Integer> {

    @Query(value = "SELECT m.Id_membership, m.Start_date, m.Expiration_date, m.Payment, m.User FROM user u join membership m on (u.Id_user = m.User) WHERE u.Id_user = :id_user && (m.Start_date <= NOW() && m.Expiration_date >= NOW())", nativeQuery = true)
    Optional<Membership> checkMembershipByUser(@Param("id_user") Integer id_user);


    @Query("select m from Membership m where m.Expiration_date between current_date and :pw")
    Collection<Membership> membershipsToFinish(@Param("pw")Date plusaWeek);

    @Modifying
    @Query("update Membership m set m.Expiration_date = :date where m.Id_membership = :id")
    void updateExpiryDate(@Param("date")Date date, @Param("id") Integer id );
}
