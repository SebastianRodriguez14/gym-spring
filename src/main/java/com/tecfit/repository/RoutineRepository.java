package com.tecfit.repository;

import com.tecfit.model.Exercise;
import com.tecfit.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoutineRepository extends JpaRepository<Routine,Integer> {
    @Query(value="select * from routine r inner join body_part p on r.Body_part= p.Id_part where p.Id_part = id_part;",nativeQuery = true)
    Collection<Routine> findByBodypart(@Param("id_part")Integer Id_part) throws Exception;

    @Query("SELECT new Exercise(e.Id_exercise, e.Name, e.Break_time,e.File, e.Type, e.Amount) from Exercise e inner join Routine_exercise re " +
            "on re.Exercise = e.Id_exercise where re.Routine = :id")
    Collection<Exercise> findExerciseByRoutine(@Param("id") Integer id);

}
