package com.tecfit.service;

import com.tecfit.model.Trainer;
import com.tecfit.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TrainerServiceImpl implements TrainerService{

    @Autowired
    private TrainerRepository trainerRepository;


    @Override
    public Collection<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer findById(Integer id) {
        return trainerRepository.findById(id).get();
    }
}
