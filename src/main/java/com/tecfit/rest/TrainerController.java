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

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("/all")
    public Collection<Trainer> findAll(){
        return trainerService.findAll();
    }

    @GetMapping("/{id}")
    public Trainer findById(@PathVariable("id") int id){
        return trainerService.findById(id);
    }

    @PostMapping("/post")
    public Trainer postTrainer(@RequestParam MultipartFile multipartFile, @RequestBody Trainer trainer) throws IOException {
        System.out.println("hasdad");
        return trainerService.postTrainer(trainer, multipartFile);
    }

    @DeleteMapping("/upload/{id}")
    public ResponseEntity<Map> upload(@PathVariable String id) throws IOException {
        Map result = cloudinaryService.delete(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
