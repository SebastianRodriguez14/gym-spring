package com.tecfit.repository;

import com.tecfit.model.Routine_exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoutineExerciseRepository extends JpaRepository<Routine_exercise, Integer> {


    @Query("SELECT new Routine_exercise(re.Routine, re.Exercise, re.Sets, re.Amount) from Routine_exercise re where re.Routine = :id")
    public Collection<Routine_exercise> findRoutine_exerciseByRoutine(@Param("id") Integer id);

}
