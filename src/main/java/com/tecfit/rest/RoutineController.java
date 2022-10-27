package com.tecfit.rest;

import com.tecfit.model.Routine;
import com.tecfit.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("routine")
public class RoutineController {
    @Autowired
    private RoutineService routineService;

    @GetMapping("/search/{id_part}")
    public Routine findByBodypart(@PathVariable("id_part")int id_part)throws Exception{
        return routineService.findByBodypart(id_part);
    }
}
