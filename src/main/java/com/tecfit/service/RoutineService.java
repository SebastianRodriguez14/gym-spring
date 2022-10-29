package com.tecfit.service;

import com.tecfit.model.Exercise;
import com.tecfit.model.Routine;
import com.tecfit.model.custom.RoutineCustom;

import java.util.Collection;

public interface RoutineService {
    Routine findById(int id);

    Collection<RoutineCustom> findByBodypart(Integer id_part);

    Collection<Exercise> findExerciseByRoutine(Integer id);
}
