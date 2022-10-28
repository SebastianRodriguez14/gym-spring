package com.tecfit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routine")
public class Routine {

    @Id
    private Integer Id_routine;

    private String Name;

    @ManyToOne
    @JoinColumn(name = "Body_part")
    private Body_part Body_part;

    @OneToOne
    @JoinColumn(name = "Image")
    private File Image;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "routine_exercise",
        joinColumns = {@JoinColumn(name = "Routine")},
        inverseJoinColumns = {@JoinColumn(name = "Exercise")}
    )
    private List<Exercise> Exercises = new ArrayList<Exercise>();
}
