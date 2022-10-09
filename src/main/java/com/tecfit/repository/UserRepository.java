package com.tecfit.repository;

import com.tecfit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user u where u.Email =:Email", nativeQuery = true)
    public User findByEmail(@Param("Email") String Email) throws Exception;
}
