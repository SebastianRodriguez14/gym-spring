package com.tecfit.repository;

import com.tecfit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user u where u.Email =:Email", nativeQuery = true)
    User findByEmail(@Param("Email") String Email) throws Exception;


    @Modifying
    @Transactional
    @Query(value = "update User u set u.Membership = :membership where u.Id_user = :id_user")
    Integer updateMembership(@Param("membership") Boolean active_membership, @Param("id_user") Integer id_user);

}
