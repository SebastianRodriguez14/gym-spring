package com.tecfit.rest;

import com.tecfit.model.Trainer;
import com.tecfit.service.CloudinaryService;
import com.tecfit.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

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

    @PostMapping("/post")
    public Trainer postTrainer(@RequestBody Trainer trainer) {
        return trainerService.postTrainer(trainer);
    }

    @PutMapping("/put/{id}")
    public Trainer putTrainer(@RequestBody Trainer trainer, @PathVariable Integer id){
        trainer.setId_trainer(id);
        return trainerService.putTrainer(trainer);
    }

}
