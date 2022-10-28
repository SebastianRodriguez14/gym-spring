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

    @Column(name = "Name")
    private String Name;

    @Column(name = "Break_time")
    private int Break_time;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "File")
    private File File;

    @ManyToOne
    @JoinColumn(name = "Type")
    private Type Type;

    @Column(name = "Amount")
    private int Amount;

}
