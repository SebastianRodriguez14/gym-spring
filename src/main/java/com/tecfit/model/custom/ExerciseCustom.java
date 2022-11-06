package com.tecfit.model.custom;

import com.tecfit.model.File;
import com.tecfit.model.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExerciseCustom {

    private Integer Id_exercise;
    private String Name;
    private Integer Break_time;
    private Integer Amount;
    private Integer Sets;
    private File File;
    private Type Type;
}
