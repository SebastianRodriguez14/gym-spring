package com.tecfit.service;

import com.tecfit.model.Body_part;
import com.tecfit.repository.BodyPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BodyPartServiceImpl implements BodyPartService {

    @Autowired
    private BodyPartRepository bodyPartRepository;

    @Override
    public Collection<Body_part> findAll() {
        return bodyPartRepository.findAll();
    }
}
