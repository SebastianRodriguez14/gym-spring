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

    @Column(name = "Name")
    private String Name;

    @Column(name = "Status")
    private Boolean Status;

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

    public Routine(Integer id_routine, String name, File image, Boolean status) {
        Id_routine = id_routine;
        Name = name;
        Image = image;
        Status = status;
    }
}
