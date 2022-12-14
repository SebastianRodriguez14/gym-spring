package com.tecfit.model.custom;

import com.tecfit.model.Body_part;
import com.tecfit.model.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoutineCustom {

    private Integer Id_routine;
    private String Name;
    private File Image;
    private Boolean Status;

}
