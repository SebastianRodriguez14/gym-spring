package com.tecfit.service;

import com.tecfit.model.Exercise;
import com.tecfit.model.Routine;
import com.tecfit.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class RoutineServiceImpl implements RoutineService {

    @Autowired
    private RoutineRepository routineRepository;

    @Override
    public Routine findById(int id) {
        return routineRepository.findById(id).get();
    }
    @Override
    public Collection<Routine> findByBodypart (Integer id_part) throws Exception {
        return routineRepository.findByBodypart(id_part);
    }
    @Override
    public Collection<Exercise> findExerciseByRoutine(Integer id) {
        return routineRepository.findExerciseByRoutine(id);
    }
}
