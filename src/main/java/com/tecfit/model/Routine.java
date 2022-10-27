package com.tecfit.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="routine")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_routine;
    private String Name;

    @ManyToOne
    @JoinColumn(name="Body_part",nullable = false)
    private Body_part Body_part;

    @ManyToOne
    @JoinColumn(name = "Image",nullable = false)
    private File Image;

}
