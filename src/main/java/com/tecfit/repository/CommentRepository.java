package com.tecfit.repository;

import com.tecfit.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query("select new Comment(c.Id_comment, c.Content, c.User) from Comment c inner join Routine r " +
        "on r.Id_routine= c.Routine.Id_routine where r.Id_routine=:idroutine")
    Collection<Comment> findByRoutine(@Param("idroutine")Integer idroutine);
}
