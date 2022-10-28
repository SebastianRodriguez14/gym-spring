package com.tecfit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_exercise;
    private String Name;
    private int Break;
    private int Amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "File")
    private File File;

    @ManyToOne
    @JoinColumn(name = "Type")
    private Type Type;

}
