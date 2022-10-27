package com.tecfit.service;

import com.tecfit.model.Routine;
import com.tecfit.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutineServiceImpl implements RoutineService{

    @Autowired
    private RoutineRepository routineRepository;

    @Override
    public Routine findByBodypart(Integer id_part) throws Exception {
        return routineRepository.findByBodypart(id_part);
    }
}
