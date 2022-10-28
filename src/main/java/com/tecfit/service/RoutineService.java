package com.tecfit.service;

import com.tecfit.model.Routine;

import java.util.Collection;

public interface RoutineService {
    Routine findById(int id);

    Collection<Routine> findByBodypart(Integer id_part) throws Exception;
}
