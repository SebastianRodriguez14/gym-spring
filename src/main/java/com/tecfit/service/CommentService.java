package com.tecfit.service;

import com.tecfit.model.Comment;
import com.tecfit.model.custom.CommentCustom;

import java.util.Collection;

public interface CommentService {

    Collection<Comment> findAll();

    Collection<CommentCustom> findByRoutine(Integer id_routine);

    Comment save(Comment comment);

}
