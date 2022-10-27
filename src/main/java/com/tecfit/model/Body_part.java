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
@Table(name = "body_part")
public class Body_part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_part;
    private String Name;
}
