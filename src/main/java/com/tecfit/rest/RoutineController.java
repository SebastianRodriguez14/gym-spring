package com.tecfit.rest;

import com.tecfit.model.Routine;
import com.tecfit.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("routine")
public class RoutineController {

    @Autowired
    private RoutineService routineService;


    @GetMapping("/{id}")
    public Routine findById(@PathVariable("id") int id){
        return routineService.findById(id);
    }
    @GetMapping("/search/{id_part}")
    public Routine findByBodypart(@PathVariable("id_part")int id_part)throws Exception{
        return routineService.findByBodypart(id_part);
    }
}
