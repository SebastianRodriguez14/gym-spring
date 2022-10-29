package com.tecfit.repository;

import com.tecfit.model.Exercise;
import com.tecfit.model.Routine;
import com.tecfit.model.custom.RoutineCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoutineRepository extends JpaRepository<Routine,Integer> {
    @Query("select new Routine(r.Id_routine,r.Name,r.Image) from Routine r inner join Body_part p " +
            "on p.Id_part= r.Id_routine where p.Id_part =:idpart")
    Collection<Routine> findByBodypart(@Param("idpart")Integer idpart);

    @Query("SELECT new Exercise(e.Id_exercise, e.Name, e.Break_time,e.File, e.Type, e.Amount) from Exercise e inner join Routine_exercise re " +
            "on re.Exercise = e.Id_exercise where re.Routine = :id")
    Collection<Exercise> findExerciseByRoutine(@Param("id") Integer id);




}
