package com.nestingsolutions.nestingsolutions.entities;

import javax.persistence.*;

@Entity
@Table(name = "package")
public class Package {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Double price;
}
