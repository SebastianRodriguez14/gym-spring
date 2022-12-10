package com.tecfit.service;

import com.tecfit.model.Comment;
import com.tecfit.model.custom.CommentCustom;
import com.tecfit.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Collection<Comment> findAll() {return commentRepository.findAll();}

    @Override
    public Collection<CommentCustom> findByRoutine(Integer id_routine) {
        Collection<Comment> comments = commentRepository.findByRoutine(id_routine);
        Collection<CommentCustom> commentCustoms = new ArrayList<>();

        for(Comment comment: comments){
            commentCustoms.add(new CommentCustom(comment.getId_comment(), comment.getContent(), comment.getUser()));

        }
        return commentCustoms;
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
