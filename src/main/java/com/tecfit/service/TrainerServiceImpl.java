package com.tecfit.service;

import com.tecfit.model.File;
import com.tecfit.model.Trainer;
import com.tecfit.repository.FileRepository;
import com.tecfit.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

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

    @Override
    public Trainer postTrainer(Trainer trainer){
        return trainerRepository.save(trainer);
    }

    @Override
    public Trainer putTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
}
