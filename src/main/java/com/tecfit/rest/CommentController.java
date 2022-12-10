package com.tecfit.rest;

import com.tecfit.model.Comment;
import com.tecfit.model.custom.CommentCustom;
import com.tecfit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public Collection<Comment>findAll(){
        return commentService.findAll();
    }

    @GetMapping("search/{id_routine}")
    public Collection<CommentCustom> findByRoutine(@PathVariable("id_routine")int id_routine)throws Exception{
        return commentService.findByRoutine(id_routine);
    }

    @PostMapping("/post")
    public Comment add(@RequestBody Comment comment){return commentService.save(comment);}

}
