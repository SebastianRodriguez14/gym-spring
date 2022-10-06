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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_user;
    private String Email;
    private String Password;
    private String Name;
    private String Lastname;
    private String Phone;
    private Boolean Membership;

    @ManyToOne
    @JoinColumn(name = "Image", nullable = false)
    private File Image;
}
