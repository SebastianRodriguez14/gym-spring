package com.tecfit.repository;

import com.tecfit.model.Body_part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyPartRepository extends JpaRepository<Body_part, Integer> {
}
