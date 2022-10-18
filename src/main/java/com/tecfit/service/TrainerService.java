package com.tecfit.service;

import com.tecfit.model.Trainer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

public interface TrainerService {
    Collection<Trainer> findAll();
    Trainer findById(Integer id);

    Trainer postTrainer(Trainer trainer, MultipartFile multipartFile) throws IOException;

}
