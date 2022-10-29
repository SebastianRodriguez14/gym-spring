package com.tecfit.service;

import com.tecfit.model.Exercise;
import com.tecfit.model.Routine;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoutineService {
    Routine findById(int id);

    Collection<Routine> findByBodypart(Integer id_part) throws Exception;

    Collection<Exercise> findExerciseByRoutine(Integer id);
}
