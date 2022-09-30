package com.tecfit.service;

import com.tecfit.model.Trainer;

import java.util.Collection;

public interface TrainerService {
    Collection<Trainer> findAll();
    Trainer findById(Integer id);
}
