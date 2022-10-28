package com.tecfit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(Routine_exercise.class)
@Table(name = "routine_exercise")
public class Routine_exercise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Routine")
    private  Integer Routine;

    @Id
    @Column(name = "Exercise")
    private Integer Exercise;

    private int Sets;

}
