package com.tecfit.repository;

import com.tecfit.model.Exercise;
import com.tecfit.model.Routine;
import com.tecfit.model.custom.ExerciseCustom;
import com.tecfit.model.custom.RoutineCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoutineRepository extends JpaRepository<Routine,Integer> {
    @Query("select new Routine(r.Id_routine,r.Name,r.Image, r.Status) from Routine r inner join Body_part p " +
            "on p.Id_part= r.Body_part.Id_part where p.Id_part =:idpart")
    Collection<Routine> findByBodypart(@Param("idpart")Integer idpart);

    @Query("SELECT new com.tecfit.model.custom.ExerciseCustom(e.Id_exercise, e.Name, e.Break_time, re.Amount, re.Sets, e.File, e.Type) from Routine_exercise re inner join Exercise e " +
            "on re.Exercise = e.Id_exercise where re.Routine = :id")
    Collection<ExerciseCustom> findExerciseByRoutine(@Param("id") Integer id);

    @Query(value = "select * from routine r ORDER BY RAND() LIMIT 3",nativeQuery = true)
    Collection<Routine> listRoutineRandom();

}
