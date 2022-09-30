package com.tecfit.rest;

import com.tecfit.model.Trainer;
import com.tecfit.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController 
@CrossOrigin("*")
@RequestMapping("trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/all")
    public Collection<Trainer> findAll(){
        return trainerService.findAll();
    }

    @GetMapping("/{id}")
    public Trainer findById(@PathVariable("id") int id){
        return trainerService.findById(id);
    }
}
