package com.tecfit.rest;

import com.tecfit.model.Exercise;
import com.tecfit.model.Routine;
import com.tecfit.model.custom.ExerciseCustom;
import com.tecfit.model.custom.RoutineCustom;
import com.tecfit.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("routine")
public class RoutineController {

    @Autowired
    private RoutineService routineService;


    @GetMapping("/{id}")
    public Routine findById(@PathVariable("id") int id){
        return routineService.findById(id);
    }
    @GetMapping("/search/{id_part}")
    public Collection<RoutineCustom> findByBodypart(@PathVariable("id_part")int id_part)throws Exception{
        return routineService.findByBodypart(id_part);
    }

    @GetMapping("/exercises/{id}")
    public Collection<ExerciseCustom> listExercises(@PathVariable("id") int id){
        return routineService.findExerciseByRoutine(id);
    }

    @GetMapping("list_random")
    public Collection<RoutineCustom> listRoutineRandom(){
        return routineService.listRoutineRandom();
    }
}
