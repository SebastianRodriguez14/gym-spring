package com.tecfit.repository;

import com.tecfit.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoutineRepository extends JpaRepository<Routine,Integer> {
    @Query(value="select * from routine r inner join body_part p on r.Body_part= p.Id_part where p.Id_part = id_part;",nativeQuery = true)
    Routine findByBodypart(@Param("id_part")Integer Id_part) throws Exception;
}
