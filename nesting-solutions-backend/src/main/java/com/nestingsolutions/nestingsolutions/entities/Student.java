package com.nestingsolutions.nestingsolutions.entities;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @ManyToOne()
    @JoinColumn(name = "contract", referencedColumnName = "id")
    private Contract contract;

    @OneToMany(mappedBy = "student")
    private Set<Application> applications;
}
