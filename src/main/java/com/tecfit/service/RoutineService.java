package com.tecfit.service;

import com.tecfit.model.Routine;

public interface RoutineService {

    Routine findByBodypart(Integer id_part) throws Exception;
}
