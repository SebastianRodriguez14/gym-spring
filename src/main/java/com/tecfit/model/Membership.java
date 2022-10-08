package com.tecfit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "membership")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_membership;
    private Date Start_date;
    private Date Expiration_date;
    private Double Payment;

    @OneToOne
    @JoinColumn(name = "User")
    private User User;
}
