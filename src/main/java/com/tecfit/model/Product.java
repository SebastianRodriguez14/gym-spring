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
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_product;
    private String Name;
    private Double Price;
    private Double Discount;
    private boolean Status;
    @ManyToOne
    @JoinColumn(name = "Image", nullable = false)
    private File Image;

}
